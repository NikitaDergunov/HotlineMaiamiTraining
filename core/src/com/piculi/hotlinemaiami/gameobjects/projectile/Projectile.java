package com.piculi.hotlinemaiami.gameobjects.projectile;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Projectile {
    private final float startX;
    private final float startY;
    float x;
    float y;
    int width;
    int height;
    Color color;
    int speed;
    double spread;
    double heading;
    boolean dead = false;

    protected Projectile(float x, float y, int speed, double heading, int width, int height, int spreadInDegrees, Color color) {
        this.startX = x;
        this.startY = y;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.heading = heading;
        alterHeading(spreadInDegrees);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void update(){
        x += speed * Math.cos(heading);
        y += speed * Math.sin(heading);
        if(Math.abs(x - startX) > 1000 || Math.abs(y - startY) > 1000){
            dead = true;
        }

    }
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rectLine(x,y, (float) (x+height * Math.cos(heading)),(float) (y+height * Math.sin(heading)),width);
        shapeRenderer.end();

    }


    public boolean isDead() {
        return dead;
    }
    private void alterHeading(double spread){
        heading += Math.toRadians(Math.random() * spread - spread/2);
    }
}
