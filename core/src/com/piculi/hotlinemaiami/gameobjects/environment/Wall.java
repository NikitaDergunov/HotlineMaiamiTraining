package com.piculi.hotlinemaiami.gameobjects.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Json;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.Weapon;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.Projectile;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.Rail;

import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

public class Wall implements Serializable {
    float x;
    float y;
    Color color;
    float width;
    float height;
    public boolean isColliding(Human human){
        human.getWeapon().ifPresent(weapon-> ((Weapon)weapon).getFiredBullets().forEach(bullet->{
            if (isColliding(bullet)){
                bullet.setDead(true);
            }
        }));
        boolean isColliding = isCollidingInternalHuman(human);
        if (isColliding){
            pushOut(human);
            color = Color.RED;
        }else {
            color = Color.WHITE;
        }
        return isColliding;
    }
    public boolean isColliding(Projectile projectile){
        boolean isColliding = isCollidingInternalProjectile(projectile);
        if (isColliding){
            color = Color.RED;
        }else {
            color = Color.WHITE;
        }
        return !(projectile instanceof Rail) && isColliding;
    }

    private boolean isCollidingInternalProjectile(Projectile projectile){
        return x < projectile.getX() + projectile.getWidth() &&
                x + width > projectile.getX() &&
                y < projectile.getY() + projectile.getHeight() &&
                y + height > projectile.getY();
    }

        private boolean isCollidingInternalHuman(Human human){
        float circleDistanceX = Math.abs(human.getX() - x - width/2);
        float circleDistanceY = Math.abs(human.getY() - y - height/2);

        if (circleDistanceX > (width/2 + human.getRadius())) { return false; }
        if (circleDistanceY > (height/2 + human.getRadius())) { return false; }

        if (circleDistanceX <= (width/2)) { return true; }
        if (circleDistanceY <= (height/2)) { return true; }

        float cornerDistance_sq =  ((int) (circleDistanceX - width/2))^2 +
                ((int)(circleDistanceY - height/2))^2;

        return (cornerDistance_sq <= (human.getRadius()^2));
    }
    private void pushOut(Human human){
        float overlapX = 0;
        float overlapY = 0;

        // Calculate overlap on x axis
        if (human.getX() < x) {
            overlapX = (human.getX() + human.getRadius()) - x;
        } else {
            overlapX = (x + width) - (human.getX() - human.getRadius());
        }

        // Calculate overlap on y axis
        if (human.getY() < y) {
            overlapY = (human.getY() + human.getRadius()) - y;
        } else {
            overlapY = (y + height) - (human.getY() - human.getRadius());
        }

        // Determine the direction of the human's movement
        float directionX = human.getX() - human.getPreviousX();
        float directionY = human.getY() - human.getPreviousY();

        // Push human out of wall along the axis of least penetration and in the direction of the human's movement
        if (Math.abs(overlapX) < Math.abs(overlapY)) {
            human.setX(human.getX() - overlapX * Math.signum(directionX));
        } else {
            human.setY(human.getY() - overlapY * Math.signum(directionY));
        }
    }


    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    public static Wall fromJson(File wallJsonFile){
        Json json = new Json();
        String wallJsonString = readStringFromFile(wallJsonFile);
        return json.fromJson(Wall.class, wallJsonString);
    }
    private static String readStringFromFile(File file){
        StringBuilder stringBuilder = new StringBuilder();
        try(FileReader fileReader = new FileReader(file)){
            int c;
            while ((c = fileReader.read()) != -1){
                stringBuilder.append((char) c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
