package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_DISTANCE;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_SPEED;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_WIDTH;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_SPREAD;

public class PistolBullet extends Projectile{
    protected PistolBullet(float x, float y, double heading) {
        super(x, y, PISTOL_BULLET_SPEED, heading,PISTOL_BULLET_WIDTH,PISTOL_BULLET_WIDTH,PISTOL_SPREAD,PISTOL_BULLET_DISTANCE , PISTOL_BULLET_COLOR);
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
