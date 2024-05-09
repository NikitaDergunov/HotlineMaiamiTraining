package com.piculi.hotlinemaiami;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.piculi.hotlinemaiami.HotlineMaiami;

import static com.piculi.hotlinemaiami.constants.GameConstants.GAME_HEIGHT;
import static com.piculi.hotlinemaiami.constants.GameConstants.GAME_WIDTH;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("HotlineMaiami");
		config.setWindowedMode(GAME_WIDTH, GAME_HEIGHT);
		new Lwjgl3Application(new HotlineMaiami(), config);
	}
}
