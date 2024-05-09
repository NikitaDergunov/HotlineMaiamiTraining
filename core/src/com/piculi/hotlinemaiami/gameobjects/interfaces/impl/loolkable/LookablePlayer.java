package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.loolkable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Lookable;

public class LookablePlayer implements Lookable {
    @Override
    public void look(Human human) {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        human.getCamera().unproject(touchPos);
        double vectorX = touchPos.x - human.x;
        double vectorY = touchPos.y - human.y;
        double angle = Math.atan2(vectorY, vectorX);
        // Normalize the angle to be within the range of 0 to 2 * Math.PI
        angle = angle % (2 * Math.PI);
        if (angle < 0) {
            angle += 2 * Math.PI;
        }
        human.heading = angle;
    }
}
