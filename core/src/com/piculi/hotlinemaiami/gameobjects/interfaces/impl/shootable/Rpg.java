package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.projectile.ProjectileType;

import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_WIDTH;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_FIRED_COUNT;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_MAG_CAPACITY;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_RELOAD_TIME;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_TIME_BETWEEN_SHOTS;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_WIDTH;

public class Rpg extends Weapon{
    public Rpg(int x, int y) {
        super(x, y, RPG_MAG_CAPACITY, RPG_MAG_CAPACITY, 2, RPG_RELOAD_TIME, RPG_TIME_BETWEEN_SHOTS, RPG_BULLET_FIRED_COUNT, ProjectileType.ROCKET, RPG_BULLET_COLOR);
    }


    @Override
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch) {
        super.draw(shapeRenderer, spriteBatch, RPG_HEIGHT, RPG_WIDTH);
    }
}
