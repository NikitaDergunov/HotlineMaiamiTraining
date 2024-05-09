package com.piculi.hotlinemaiami.gameobjects.interfaces;

import com.piculi.hotlinemaiami.gameobjects.Human;

public interface Shootable {
    public boolean areBulletsColiding(Human human);
    public void reload();
    public void shoot();
    public void update();
    public void draw();
}
