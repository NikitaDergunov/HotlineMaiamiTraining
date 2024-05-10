package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.ProjectileType;

import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_MAG_CAPACITY;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_RELOAD_TIME;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_TIME_BETWEEN_SHOTS;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_WIDTH;

public class Railgun extends Weapon{
    public Railgun(int x, int y, boolean dispalyAmmo) {
        super(x, y, RAILGUN_MAG_CAPACITY, RAILGUN_MAG_CAPACITY, 3, RAILGUN_RELOAD_TIME, RAILGUN_TIME_BETWEEN_SHOTS, 1, ProjectileType.RAILGUN_BULLET, RAILGUN_COLOR, dispalyAmmo);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch, Camera camera) {
        super.draw(shapeRenderer, spriteBatch, camera, RAILGUN_HEIGHT, RAILGUN_WIDTH);
    }

    @Override
    public boolean areBulletsColiding(Human human) {
        boolean b = super.areBulletsColiding(human);
        if(b){
            human.dead = true;
        }
        return b;
    }
}
