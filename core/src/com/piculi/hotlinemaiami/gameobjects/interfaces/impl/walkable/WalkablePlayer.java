package com.piculi.hotlinemaiami.gameobjects.interfaces.impl.walkable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Walkable;

public class WalkablePlayer implements Walkable {
    @Override
    public void walk(Human human) {
        int speed = human.speed;
        int x = human.x;
        int y = human.y;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
          x -= speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= speed;
        }
        human.x = x;
        human.y = y;
    }
}
