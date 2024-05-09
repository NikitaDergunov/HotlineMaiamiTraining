package com.piculi.hotlinemaiami.gameobjects.projectile;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Projectile {
    int x;
    int y;
    int speed;
    double heading;

    protected Projectile(int x, int y, int speed, double heading) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.heading = heading;
    }

    public void update(){

    }
    public void draw(ShapeRenderer shapeRenderer){

    }


}
