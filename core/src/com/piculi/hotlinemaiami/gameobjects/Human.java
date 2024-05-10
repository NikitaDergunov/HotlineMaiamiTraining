package com.piculi.hotlinemaiami.gameobjects;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Lookable;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Shootable;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Walkable;

import java.util.Optional;

import static com.piculi.hotlinemaiami.constants.CharacterConstants.CHARACTER_WIDTH;

public  class Human {
     public float x;
     public float y;
     private float previousX;
        private float previousY;
    public int radius;
    public double heading = 0;
     public int speed;
    Color color;
    private Optional<Shootable> weapon;
    private Walkable movement;
    private Lookable look;
    private Camera camera;
    public boolean dead = false;
    float hits = 0;
    public Human(float x, float y, Color color, Shootable weapon, Walkable movement, int speed, Lookable look, Camera camera){
        this.x = x;
        this.y = y;
        previousX = x;
        previousY = y;
        this.radius = CHARACTER_WIDTH;
        this.color = color;
        this.weapon =  Optional.ofNullable(weapon);
        this.movement = movement;
        this.speed = speed;
        this.look = look;
        this.camera = camera;
    }
    public void update(){
        look.look(this);
        previousX = x;
        previousY = y;
        movement.walk(this);
        weapon.ifPresent(shootable -> shootable.update(this));
    }
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch, Camera camera){
        weapon.ifPresent(shootable -> shootable.draw(shapeRenderer, spriteBatch, camera));
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius-hits);
        shapeRenderer.end();

        shapeRenderer.begin();
        shapeRenderer.setColor(Color.BLACK);

        // Calculate the coordinates of the second end of the line (radius)
        double normalizedHeading = heading % (2 * Math.PI);
        float endX = (float) (x + radius * Math.cos(heading));
        float endY = (float) (y + radius * Math.sin(heading));
        shapeRenderer.line(x, y, endX,endY );

        shapeRenderer.end();
    }
    public void setWeapon(Shootable weapon){
        this.weapon = Optional.of(weapon);
    }
    public Optional<Shootable> getWeapon(){
        return weapon;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRadius() {
        return radius;
    }

    public Camera getCamera() {
        return camera;
    }

    public float getPreviousX() {
        return previousX;
    }

    public float getPreviousY() {
        return previousY;
    }
    public void hit(){
        hits+=1f;
        if (hits>=radius){
            dead = true;
        }
    }
}
