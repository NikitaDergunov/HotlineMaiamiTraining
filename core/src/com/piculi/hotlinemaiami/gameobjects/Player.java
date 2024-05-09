package com.piculi.hotlinemaiami.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.piculi.hotlinemaiami.gameobjects.interfaces.Shootable;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.loolkable.LookablePlayer;
import com.piculi.hotlinemaiami.gameobjects.interfaces.impl.walkable.WalkablePlayer;

import static com.piculi.hotlinemaiami.constants.CharacterConstants.PLAYER_INIT_SPEED;

public class Player extends Human {

    public Player(float x, float y, Color color, Shootable weapon) {
        super(x, y, color, weapon, new WalkablePlayer(), PLAYER_INIT_SPEED, new LookablePlayer());
    }

    @Override
    public void update() {
        super.update();
    }
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch spriteBatch) {
      super.draw(shapeRenderer, spriteBatch);
    }
}
