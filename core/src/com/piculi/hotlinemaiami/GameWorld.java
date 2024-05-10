package com.piculi.hotlinemaiami;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.piculi.hotlinemaiami.gameobjects.Enemy;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.Player;
import com.piculi.hotlinemaiami.gameobjects.environment.Room;
import com.piculi.hotlinemaiami.gameobjects.environment.Wall;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.Ak47;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.Rpg;

import java.util.ArrayList;
import java.util.List;

import static com.piculi.hotlinemaiami.constants.GameConstants.GAME_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GameConstants.GAME_WIDTH;

public class GameWorld {
    //graphics
    ShapeRenderer shapeRenderer;
    SpriteBatch spriteBatch;
    OrthographicCamera camera;
    //game objects
    private Human player;
    private List<Wall> walls;
    private List<Enemy> enemies = new ArrayList<>();
    public GameWorld(Level level){
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        this.spriteBatch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
        camera.update();
        player = new Player(camera.position.x,camera.position.y, Color.GREEN,new Rpg(0,0,true),camera);
        walls = level.generateWalls();
        enemies.add(new Enemy(100,100,Color.RED,new Ak47(0,0, false),camera,(Player) player));
        //enemies = level.generateEnemies();
    }

    public void update(){
        player.update();
        enemies.forEach(Enemy::update);
        walls.forEach(wall -> wall.isColliding(player));
        walls.forEach(wall -> enemies.forEach(wall::isColliding));
    }
    public void draw(){
        ScreenUtils.clear(Color.GRAY);
        shapeRenderer.setProjectionMatrix(camera.combined);
        spriteBatch.setProjectionMatrix(camera.combined);
        camera.position.x=(float) player.getX();
        camera.position.y=(float) player.getY();
        camera.update();
        player.draw(shapeRenderer, spriteBatch, camera);
        walls.forEach(wall -> wall.draw(shapeRenderer));
        enemies.forEach(enemy -> enemy.draw(shapeRenderer, spriteBatch, camera));
        //rooms.forEach(room -> room.draw(shapeRenderer));
        //enemies.forEach(enemy -> enemy.draw(shapeRenderer));
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
