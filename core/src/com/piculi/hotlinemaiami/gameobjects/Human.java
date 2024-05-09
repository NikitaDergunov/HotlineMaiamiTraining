package com.piculi.hotlinemaiami.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Lookable;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Shootable;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Walkable;

import java.util.Optional;

import static com.piculi.hotlinemaiami.constants.CharacterConstants.CHARACTER_WIDTH;

public  class Human {
     public int x;
     public int y;
    private int radius;
    public double heading = 0;
     public int speed;
    Color color;
    private Optional<Shootable> weapon;
    private Walkable movement;
    private Lookable look;
    public Human(int x, int y, Color color, Shootable weapon, Walkable movement, int speed, Lookable look){
        this.x = x;
        this.y = y;
        this.radius = CHARACTER_WIDTH;
        this.color = color;
        this.weapon =  Optional.ofNullable(weapon);
        this.movement = movement;
        this.speed = speed;
        this.look = look;
    }
    public void update(){
        look.look(this);
        movement.walk(this);
    }
    public void draw(ShapeRenderer shapeRenderer){
        weapon.ifPresent(Shootable::draw);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
