package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.walkable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Walkable;

public class WalkablePlayer implements Walkable {
    @Override
    public void walk(Human human) {
        int speed = human.speed;
        float x = human.x;
        float y = human.y;
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
          x -= speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            x += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            y += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            y -= speed;
        }
        human.x = x;
        human.y = y;
    }
}
