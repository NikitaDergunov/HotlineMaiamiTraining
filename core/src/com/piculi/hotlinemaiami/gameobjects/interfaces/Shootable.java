package com.piculi.hotlinemaiami.gameobjects.interfaces;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.Room;

import java.util.List;

public interface Shootable {
    public boolean areBulletsColiding(Human human);
    boolean areBulletsColiding(List<Room> rooms);
    public void reload();
    public void shoot();
    public void update(Human owner);
    public void draw(ShapeRenderer shapeRenderer);
}
