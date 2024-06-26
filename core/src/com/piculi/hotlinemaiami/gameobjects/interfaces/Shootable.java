package com.piculi.hotlinemaiami.gameobjects.interfaces;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.Human;
import com.piculi.hotlinemaiami.gameobjects.environment.Room;

import java.util.List;

public interface Shootable {
    public boolean areBulletsColiding(Human human);
    boolean areBulletsColiding(List<Room> rooms);
    void reload();
    void shoot();

    public void update(Human owner);
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch, Camera camera);
}
