package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_BULLET_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_BULLET_DISTANCE;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_BULLET_SPEED;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_BULLET_WIDTH;
import static com.piculi.hotlinemaiami.constants.GunConstants.AK47_SPREAD;

public class Ak47Bullet extends Projectile{
    protected Ak47Bullet(float x, float y, double heading) {
        super(x,y,AK47_BULLET_SPEED,heading,AK47_BULLET_WIDTH,AK47_BULLET_WIDTH,AK47_SPREAD,AK47_BULLET_DISTANCE , AK47_BULLET_COLOR);

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
