package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.Room;
import com.piculi.hotlinemaiami.gameobjects.projectile.ProjectileType;

import java.util.List;

import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_MAG_CAPACITY;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_RELOAD_TIME;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_WIDTH;

public class Pistol extends Weapon {
    public Pistol(int x, int y) {
        super(x, y, PISTOL_MAG_CAPACITY, PISTOL_MAG_CAPACITY, getRandomIntInRange(1,5), PISTOL_RELOAD_TIME, ProjectileType.PISTOL_BULLET, PISTOL_COLOR);
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
    public void reload() {
        super.reload();
    }

    @Override
    public void shoot() {

    }

    @Override
    public void update(Human owner) {
        super.update(owner);

    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rectLine(x,y, (float) (x+PISTOL_HEIGHT * Math.cos(heading)),(float) (y+PISTOL_HEIGHT * Math.sin(heading)),PISTOL_WIDTH);
        shapeRenderer.end();

    }
}
