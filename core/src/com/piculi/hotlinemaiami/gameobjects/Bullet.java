package com.piculi.hotlinemaiami.gameobjects;

import com.piculi.hotlinemaiami.gameobjects.interfaces.Shootable;

public class Bullet implements Shootable {
    int x;
    int y;


    @Override
    public boolean areBulletsColiding(Human human) {
        return false;
    }

    @Override
    public void reload() {

    }

    @Override
    public void shoot() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}
