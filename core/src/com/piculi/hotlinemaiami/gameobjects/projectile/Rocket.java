package com.piculi.hotlinemaiami.gameobjects.projectile;

import com.badlogic.gdx.graphics.Color;

public class Rocket extends Projectile{
    protected Rocket(int x, int y, int speed, double heading) {
        super(x, y, speed, heading, 5, 5,5, Color.BLACK);
    }
}
