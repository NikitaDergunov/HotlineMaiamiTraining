package com.piculi.hotlinemaiami.gameobjects.projectile;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.piculi.hotlinemaiami.constants.GunConstants.PISTOL_BULLET_SPEED;

public class ProjectileFactory {
    public static Projectile createProjectile(ProjectileType type, float x, float y, double heading){
        switch (type){
            case PISTOL_BULLET:
                return new PistolBullet(x, y, heading);
            case AK47_BULLET:
                //return new NotImplementedException();
                throw  new NotImplementedException();
            case ROCKET:
                //return new Rocket(x, y, 3, heading);
                throw  new NotImplementedException();
            case SHOTGUN_BULLET:
                //return new ShotgunBullet(x, y, 3, heading);
                throw  new NotImplementedException();
            default:
                return null;
        }
    }
}
