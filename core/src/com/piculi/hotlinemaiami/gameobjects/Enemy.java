package com.piculi.hotlinemaiami.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Shootable;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.loolkable.LookableEnemy;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.walkable.WalkableEnemy;

import static com.piculi.hotlinemaiami.constants.CharacterConstants.ENEMY_INIT_SPEED;

public class Enemy extends Human {
    public Enemy(int x, int y, Color color, Shootable weapon) {
        super(x, y, color, weapon, new WalkableEnemy(),ENEMY_INIT_SPEED, new LookableEnemy());
    }

    @Override
    public void update() {

    }
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch) {
        super.draw(shapeRenderer, spriteBatch);
    }
}
