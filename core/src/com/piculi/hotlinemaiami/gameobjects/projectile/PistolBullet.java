package com.piculi.hotlinemaiami.gameobjects.projectile;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_SPEED;
import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_WIDTH;

public class PistolBullet extends Projectile{
    protected PistolBullet(float x, float y, double heading) {
        super(x, y, PISTOL_BULLET_SPEED, heading,PISTOL_BULLET_WIDTH,PISTOL_BULLET_WIDTH,PISTOL_BULLET_COLOR);
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
