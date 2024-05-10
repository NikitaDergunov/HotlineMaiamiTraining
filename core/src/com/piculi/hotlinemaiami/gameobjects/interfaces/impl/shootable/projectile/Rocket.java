package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;

import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_ACCELERATION;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_COLOR;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_DISTANCE;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_SPEED;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_BULLET_WIDTH;
import static com.piculi.hotlinemaiami.constants.GunConstants.RPG_SPREAD;

public class Rocket extends Projectile{
    private float explosionRadius = 0;
    long explosionTime;
    boolean explosionDone = false;
    protected Rocket(float x, float y, double heading) {
        super(x, y, RPG_BULLET_SPEED, heading,RPG_BULLET_WIDTH,RPG_BULLET_HEIGHT,RPG_SPREAD,RPG_BULLET_DISTANCE , RPG_BULLET_COLOR);
    }
    @Override
    public void update() {
        speed+=RPG_BULLET_ACCELERATION;
        super.update();
        if (dead){
            explosionTime = System.currentTimeMillis();
        }
    }

    @Override
    public void draw(ShapeRenderer shapeRenderer) {
        explosionDone = System.currentTimeMillis() - explosionTime > 200 ;
        super.draw(shapeRenderer);
        if(dead && !explosionDone){
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.RED);
            explosionRadius = 0.75f * (System.currentTimeMillis() - explosionTime);
            shapeRenderer.circle(x,y, explosionRadius);
            shapeRenderer.end();
        }

    }
    @Override
    public boolean isCollidingWithHuman(Human human){
        if(isExploding()){
            float distanceX = human.getX() - x;
            float distanceY = human.getY() - y;
            boolean isColliding = (distanceX * distanceX) + (distanceY * distanceY) < (explosionRadius * explosionRadius);
            if(isColliding){
                human.dead = true;
            }
            return isColliding;
        }
        boolean cl = super.isCollidingWithHuman(human);
        if(cl){
            human.dead = true;
        }
        return cl;
    }

    public boolean isExplosionDone() {
        return explosionDone;
    }
    public float getExplosionRadius() {
        return explosionRadius;
    }
    public boolean isExploding(){
        return !explosionDone&&dead;
    }
}
