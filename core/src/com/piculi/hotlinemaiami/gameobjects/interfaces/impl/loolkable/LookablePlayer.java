package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.loolkable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Lookable;

public class LookablePlayer implements Lookable {
    @Override
    public void look(Human human) {
       //double vectorX = Gdx.input.getX() - human.x;
       //double vectorY = Gdx.input.getY() - human.y;
        double vectorX = Gdx.input.getX() - human.x;
        double vectorY = Gdx.graphics.getHeight() - Gdx.input.getY() - human.y;
        double angle = Math.atan2(vectorY, vectorX);
        // Normalize the angle to be within the range of 0 to 2 * Math.PI
        angle = angle % (2 * Math.PI);
        if (angle < 0) {
            angle += 2 * Math.PI;
        }
         human.heading = angle;

    }
}
