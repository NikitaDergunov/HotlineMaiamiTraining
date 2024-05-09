package com.piculi.hotlinemaiami;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.ScreenUtils;
import com.piculi.hotlinemaiami.gameobjects.environment.Wall;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.piculi.hotlinemaiami.constants.EnvironmentConstants.WALL_THICKNESS;
import static com.piculi.hotlinemaiami.constants.GameConstants.GAME_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GameConstants.GAME_WIDTH;

public class LevelCreator extends ApplicationAdapter {
    String name;
    boolean isCreatingWall = false;
    ShapeRenderer shapeRenderer;
    OrthographicCamera camera;
    List<Wall> walls = new ArrayList<>();
    Wall activeWall;
    public void update(){
       updateCamera();
         createWall();
            saveLevel();
    }
    private void createWall(){
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            isCreatingWall = true;
            activeWall = new Wall();
            // Convert screen coordinates to game world coordinates
            com.badlogic.gdx.math.Vector3 touchPos = new com.badlogic.gdx.math.Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            activeWall.setX(touchPos.x);
            activeWall.setY(touchPos.y);
            activeWall.setColor(Color.WHITE);
            activeWall.setWidth(1);
            activeWall.setHeight(1);
        }
        if(isCreatingWall){
            // Convert screen coordinates to game world coordinates for width and height
            com.badlogic.gdx.math.Vector3 touchPos = new com.badlogic.gdx.math.Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            activeWall.setWidth((activeWall.getX() - touchPos.x )*-1);
            activeWall.setHeight((activeWall.getY() - touchPos.y)*-1);
        }
        if(isCreatingWall && Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
            isCreatingWall = false;
            if(activeWall.getHeight()>activeWall.getWidth()){
                activeWall.setWidth(WALL_THICKNESS);
            }else {
                activeWall.setHeight(WALL_THICKNESS);
            }
            walls.add(activeWall);
            activeWall = null;
        }
    }

    private void updateCamera() {
        int speed = 5;
        float x = camera.position.x;
        float y = camera.position.y;
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
        camera.position.x = x;
        camera.position.y = y;
        camera.update();
    }
    private void saveLevel(){
        if (Gdx.input.isKeyPressed(Input.Keys.F1)){
            int i = 0;
        for (Wall wall : walls) {
            Json json = new Json();
            String wallJson = json.toJson(wall);
            File file = new File("levels/"+name+"/wall"+i+".json");
            i++;
            try (java.io.FileWriter fileWriter = new java.io.FileWriter(file)){
                fileWriter.write(wallJson);
            }catch (java.io.IOException e){
                e.printStackTrace();
            }
        }
        }
    }


    public void draw(){
        ScreenUtils.clear(Color.GRAY);
        shapeRenderer.setProjectionMatrix(camera.combined);
        if(activeWall != null)
            activeWall.draw(shapeRenderer);
        walls.forEach(wall -> wall.draw(shapeRenderer));
    }

    @Override
    public void create () {
        name = UUID.randomUUID().toString();
        createLevelDirectory();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GAME_WIDTH, GAME_HEIGHT);
        camera.update();
    }

    @Override
    public void render () {
        update();
        draw();
    }

    @Override
    public void dispose () {
        shapeRenderer.dispose();
    }
    private void createLevelDirectory(){
        File file = new File("levels/"+name);
        file.mkdirs();
    }

}
