package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.ProjectileType;

import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_BULLET_FIRED_COUNT;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_MAG_CAPACITY;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_RELOAD_TIME;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_TIME_BETWEEN_SHOTS;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_WIDTH;

public class Ak47 extends Weapon{
    public Ak47(int x, int y) {
        super(x, y, AK47_MAG_CAPACITY, AK47_MAG_CAPACITY, 5, AK47_RELOAD_TIME, AK47_TIME_BETWEEN_SHOTS,AK47_BULLET_FIRED_COUNT, ProjectileType.AK47_BULLET, AK47_COLOR);
    }

    @Override
    public void update(Human owner) {
        super.update(owner);

    }

    @Override
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch, Camera camera) {
        super.draw(shapeRenderer, spriteBatch, camera, AK47_HEIGHT, AK47_WIDTH);
    }
}
