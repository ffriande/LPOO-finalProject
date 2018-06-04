package com.mygdx.fallball;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fallball.view.menus.MainMenu;

/**
 * FallBall.java-The starting postion of the game.
 * @see Game
 */
public class FallBall extends Game {	
	private SpriteBatch batch;
	private AssetManager assMan;

	@Override
	public void create () {
		batch = new SpriteBatch();
		assMan = new AssetManager();
		startGame();
	}

    /**
     * Calls the function to load all the assets.
     * Sets the screen to the main menu screen.
     */
	private void startGame() {
		loadAssets();
		setScreen(new MainMenu(this));
	}

    /**
     * Loads all the assets necessary to all the screens.
     */
	private void loadAssets(){
		assMan.load("redplatform.png", Texture.class);
		assMan.load("platform.png", Texture.class);
		assMan.load("ball.png", Texture.class);
		assMan.load("finalplatform.png", Texture.class);
		assMan.load("background.png", Texture.class);
		assMan.load("winback.png", Texture.class);
		assMan.load("loseback.png", Texture.class);
		assMan.load("level1.png",Texture.class);
		assMan.load("level2.png",Texture.class);
		assMan.load("level3.png",Texture.class);
		assMan.load("level4.png",Texture.class);
		assMan.load("locked.png",Texture.class);
		assMan.load("return.png",Texture.class);
		assMan.load("LevelMode.png",Texture.class);
		assMan.load("MainMenu.png",Texture.class);
		assMan.load("sound.png",Texture.class);
		assMan.load("return.png",Texture.class);
		assMan.load("reset.png",Texture.class);
		assMan.load("infinite.png",Texture.class);
		assMan.load("start.png",Texture.class);
		assMan.load("options.png",Texture.class);
		assMan.load("exit.png",Texture.class);
		assMan.load("tryagain.png",Texture.class);

		assMan.finishLoading();
	}

	@Override
	public void dispose () {
		batch.dispose();
		assMan.dispose();
	}

    /**
     * Returns the asset manager of the game.
     * @return AssetManager data type.
     */
	public AssetManager getAssetManager() {
		return assMan;
	}

    /**
     * Returns the sprite batch of the game.
     * @return SpriteBatch data type.
     */
	public SpriteBatch getBatch() {
		return batch;
	}


}
