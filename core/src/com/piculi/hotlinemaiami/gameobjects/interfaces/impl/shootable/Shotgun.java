package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.projectile.ProjectileType;

import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_BULLET_FIRED_COUNT;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_MAG_CAPACITY;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_RELOAD_TIME;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_TIME_BETWEEN_SHOTS;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_WIDTH;

public class Shotgun extends Weapon{

    public Shotgun(int x, int y) {
        super(x, y, SHOTGUN_MAG_CAPACITY, SHOTGUN_MAG_CAPACITY, 2, SHOTGUN_RELOAD_TIME, SHOTGUN_TIME_BETWEEN_SHOTS,SHOTGUN_BULLET_FIRED_COUNT, ProjectileType.SHOTGUN_BULLET, SHOTGUN_COLOR);
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch) {
        super.draw(shapeRenderer, spriteBatch, SHOTGUN_HEIGHT, SHOTGUN_WIDTH);
    }
}
