package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.Room;
import com.piculi.hotlinemaiami.gameobjects.projectile.ProjectileType;

import java.util.List;

import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_MAG_CAPACITY;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_RELOAD_TIME;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_TIME_BETWEEN_SHOTS;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_WIDTH;

public class Pistol extends Weapon {
    public Pistol(int x, int y) {
        super(x, y, PISTOL_MAG_CAPACITY, PISTOL_MAG_CAPACITY, 2, PISTOL_RELOAD_TIME,PISTOL_TIME_BETWEEN_SHOTS, ProjectileType.PISTOL_BULLET, PISTOL_COLOR);
    }

    @Override
    public boolean areBulletsColiding(Human human) {
        return false;
    }

    @Override
    public boolean areBulletsColiding(List<Room> rooms) {
        return false;
    }


    @Override
    public void update(Human owner) {
        super.update(owner);

    }


    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch) {
        super.draw(shapeRenderer, spriteBatch, PISTOL_HEIGHT, PISTOL_WIDTH);

    }
}
