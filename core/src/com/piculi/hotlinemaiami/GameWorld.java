package com.piculi.hotlinemaiami;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.piculi.hotlinemaiami.gameobjects.Enemy;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.Player;
import com.piculi.hotlinemaiami.gameobjects.Room;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.Pistol;

import java.util.List;

public class GameWorld {
    //graphics
    ShapeRenderer shapeRenderer;
    SpriteBatch spriteBatch;
    OrthographicCamera camera;
    //game objects
    private Human player;
    private List<Room> rooms;
    private List<Enemy> enemies;
    public GameWorld(Level level){
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        this.spriteBatch = new SpriteBatch();
        camera = new OrthographicCamera();
        player = new Player(0,16, Color.GREEN,new Pistol(0,0));
        //rooms = level.generateRooms();
        //enemies = level.generateEnemies();
    }

    public void update(){
        player.update();
    }
    public void draw(){
        ScreenUtils.clear(Color.GRAY);
        camera.update();
        player.draw(shapeRenderer, spriteBatch);
        //rooms.forEach(room -> room.draw(shapeRenderer));
        //enemies.forEach(enemy -> enemy.draw(shapeRenderer));
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
