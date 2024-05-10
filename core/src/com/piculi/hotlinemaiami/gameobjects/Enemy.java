package com.piculi.hotlinemaiami.gameobjects;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Shootable;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.loolkable.LookableEnemyNaive;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.walkable.WalkableEnemyNaive;

import static com.piculi.hotlinemaiami.constants.CharacterConstants.ENEMY_INIT_SPEED;

public class Enemy extends Human {
    private float sightRadius = 200;
    private boolean seesPlayer = false;
    public Enemy(int x, int y, Color color, Shootable weapon, Camera camera, Player player) {
        super(x, y, color, weapon, new WalkableEnemyNaive(player),ENEMY_INIT_SPEED, new LookableEnemyNaive(player), camera);
    }

    @Override
    public void update() {
        super.update();
        if (seesPlayer){
            this.getWeapon().ifPresent(weapon -> weapon.shoot());
        }

    }
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch, Camera camera) {
        super.draw(shapeRenderer, spriteBatch,camera);
    }

    public float getSightRadius() {
        return sightRadius;
    }

    public boolean isSeesPlayer() {
        return seesPlayer;
    }

    public void setSeesPlayer(boolean seesPlayer) {
        this.seesPlayer = seesPlayer;
    }
}
