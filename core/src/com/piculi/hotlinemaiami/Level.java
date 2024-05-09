package com.piculi.hotlinemaiami;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.piculi.hotlinemaiami.gameobjects.Enemy;
import com.piculi.hotlinemaiami.gameobjects.environment.Wall;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private int levelNumber;
    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
    }
    public List<Wall> generateWalls() {
        List<Wall> walls = new ArrayList<>();

        FileHandle dirHandle = Gdx.files.internal("levels/" + levelNumber);
        FileHandle[] fileHandles = dirHandle.list();
        for (FileHandle fileHandle : fileHandles) {
            walls.add(Wall.fromJson(fileHandle.file()));
        }
        return walls;
    }
    public List<Enemy> generateEnemies() {
        return null;
    }
}
