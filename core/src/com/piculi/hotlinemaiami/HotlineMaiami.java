package com.piculi.hotlinemaiami;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class HotlineMaiami extends ApplicationAdapter {
	GameWorld gameWorld;
	
	@Override
	public void create () {
		this.gameWorld = new GameWorld(null);
	}

	@Override
	public void render () {
		gameWorld.update();
		gameWorld.draw();
	}
	
	@Override
	public void dispose () {
		gameWorld.dispose();
	}
}
