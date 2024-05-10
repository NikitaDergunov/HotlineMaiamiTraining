package com.piculi.hotlinemaiami;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.piculi.hotlinemaiami.gameobjects.Enemy;
import com.piculi.hotlinemaiami.gameobjects.Player;
import com.piculi.hotlinemaiami.gameobjects.environment.Wall;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private String levelName;
    public Level(String levelName) {
        this.levelName = levelName;
    }
    public List<Wall> generateWalls() {
        List<Wall> walls = new ArrayList<>();

        FileHandle dirHandle = Gdx.files.internal("levels/" + levelName + "/walls");
        FileHandle[] fileHandles = dirHandle.list();
        for (FileHandle fileHandle : fileHandles) {
            walls.add(Wall.fromJson(readStringFromFile(fileHandle.file())));
        }
        return walls;
    }
    public List<Enemy> generateEnemies(Camera camera, Player player) {
        List<Enemy> enemies = new ArrayList<>();
        FileHandle dirHandle = Gdx.files.internal("levels/" + levelName + "/enemies");
        FileHandle[] fileHandles = dirHandle.list();
        for (FileHandle fileHandle : fileHandles) {
            enemies.add(Enemy.fromJson(readStringFromFile(fileHandle.file()), camera, player));
        }
        return enemies;
    }
    private static String readStringFromFile(File file){
        StringBuilder stringBuilder = new StringBuilder();
        try(FileReader fileReader = new FileReader(file)){
            int c;
            while ((c = fileReader.read()) != -1){
                stringBuilder.append((char) c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
