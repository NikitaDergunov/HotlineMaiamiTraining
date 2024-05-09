package com.piculi.hotlinemaiami.gameobjects.environment;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.List;

public class Room {
    List<Wall> walls;

    public void draw(ShapeRenderer shapeRenderer) {
        walls.forEach(wall -> wall.draw(shapeRenderer));
    }
}
