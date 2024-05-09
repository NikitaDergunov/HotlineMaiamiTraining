package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_BULLET_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_BULLET_DISTANCE;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_BULLET_SPEED;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_BULLET_WIDTH;
import static com.piculi.hotlinemaiami.constants.GunConstants.SHOTGUN_SPREAD;

public class ShotgunBullet extends Projectile{
    protected ShotgunBullet(float x, float y, double heading) {
        super(x, y, SHOTGUN_BULLET_SPEED, heading,SHOTGUN_BULLET_WIDTH,SHOTGUN_BULLET_WIDTH,SHOTGUN_SPREAD, SHOTGUN_BULLET_DISTANCE , SHOTGUN_BULLET_COLOR);
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
