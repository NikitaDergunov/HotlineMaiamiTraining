package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Enemy;
import com.piculi.hotlinemaiami.gameobjects.Human;

public abstract class Projectile {
    private final float startX;
    private final float startY;
    float x;
    float y;
    int width;
    int height;
    Color color;
    float speed;
    int maxDistance;
    double heading;
    boolean dead = false;

    protected Projectile(float x, float y, int speed, double heading, int width, int height, int spreadInDegrees,int maxDistance, Color color) {
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
        this.maxDistance = maxDistance;
    }

    public void update(){
        x += speed * Math.cos(heading);
        y += speed * Math.sin(heading);
        if(Math.abs(x - startX) > maxDistance || Math.abs(y - startY) > maxDistance){
            dead = true;
        }

    }
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rectLine(x,y, (float) (x+height * Math.cos(heading)),(float) (y+height * Math.sin(heading)),width);
        shapeRenderer.end();

    }
    public boolean isCollidingWithHuman(Human human){
        float closestX = Math.max(x, Math.min(human.getX(), x + width));
        float closestY = Math.max(y, Math.min(human.getY(), y + height));

        float distanceX = human.getX() - closestX;
        float distanceY = human.getY() - closestY;
        boolean isColliding = (distanceX * distanceX) + (distanceY * distanceY) < (human.getRadius() * human.getRadius());
        if(isColliding){
            dead = true;
            if(human instanceof Enemy)human.hit();
        }
        return (distanceX * distanceX) + (distanceY * distanceY) <= (human.getRadius() * human.getRadius());
    }


    public boolean isDead() {
        return dead;
    }
    private void alterHeading(double spread){
        heading += Math.toRadians(Math.random() * spread - spread/2);
    }

    public float getX() {
        return x;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getY() {
        return y;
    }

    public void setDead(boolean b) {
        dead = b;
    }
}
