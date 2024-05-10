package com.piculi.hotlinemaiami.gameobjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.shootable.projectile.ProjectileType;

import java.io.Serializable;

import static com.piculi.hotlinemaiami.constants.CharacterConstants.CHARACTER_WIDTH;

public class EnemyForCreator implements Serializable {

    float x;
    float y;
    float radius = CHARACTER_WIDTH;
    ProjectileType type;
    public EnemyForCreator(){
    }
    public EnemyForCreator(float x, float y, ProjectileType type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
    public void draw(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1,0,0,1);
        shapeRenderer.circle(x, y, radius);
        shapeRenderer.end();
    }
}
