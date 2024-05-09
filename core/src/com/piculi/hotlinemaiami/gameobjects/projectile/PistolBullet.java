package com.piculi.hotlinemaiami.gameobjects.projectile;

import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_SPEED;

public class PistolBullet extends Projectile{
    protected PistolBullet(int x, int y, int speed, double heading) {
        super(x, y, PISTOL_BULLET_SPEED, heading);
    }
}
