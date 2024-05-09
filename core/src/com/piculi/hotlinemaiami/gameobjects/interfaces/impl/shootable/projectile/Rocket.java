package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_DISTANCE;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_SPEED;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_WIDTH;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_SPREAD;

public class Rocket extends Projectile{
    protected Rocket(float x, float y, double heading) {
        super(x, y, RPG_BULLET_SPEED, heading,RPG_BULLET_WIDTH,RPG_BULLET_HEIGHT,RPG_SPREAD,RPG_BULLET_DISTANCE , RPG_BULLET_COLOR);
    }
    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        super.draw(shapeRenderer);
    }
}
