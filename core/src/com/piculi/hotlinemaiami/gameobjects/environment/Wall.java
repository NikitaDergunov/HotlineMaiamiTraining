package com.piculi.hotlinemaiami.gameobjects.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Json;

import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

public class Wall implements Serializable {
    float x;
    float y;
    Color color;
    float width;
    float height;


    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    public static Wall fromJson(File wallJsonFile){
        Json json = new Json();
        String wallJsonString = readStringFromFile(wallJsonFile);
        return json.fromJson(Wall.class, wallJsonString);
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
