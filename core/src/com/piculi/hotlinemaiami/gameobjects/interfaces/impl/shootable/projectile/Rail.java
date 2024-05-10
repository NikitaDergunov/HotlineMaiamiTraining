package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

import com.badlogic.gdx.graphics.Color;

import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_BULLET_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_BULLET_DISTANCE;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_BULLET_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_BULLET_SPEED;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_BULLET_WIDTH;
import static com.piculi.hotlinemaiami.constants.GunConstants.RAILGUN_SPREAD;

public class Rail extends Projectile{
    protected Rail(float x, float y, double heading) {
        super(x, y, RAILGUN_BULLET_SPEED, heading, RAILGUN_BULLET_WIDTH, RAILGUN_BULLET_HEIGHT, RAILGUN_SPREAD,RAILGUN_BULLET_DISTANCE, RAILGUN_BULLET_COLOR);
    }
}
