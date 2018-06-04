package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.fallball.FallBall;

/**
 * ModeMenu.java-Menu to selected the mode to play.
 * @see ScreenAdapter
 */
public class ModeMenu extends ScreenAdapter {
    private FallBall game;
    private Stage stage;
    private Sprite levelSprite;
    private Sprite infiniteSprite;
    private Sprite returnSprite;
    private Texture background;

    /**
     * Class constructor.
     * Inicializes all the class variables.
     * Creates camara and viewport.
     * Loads all the spites needed.
     * @param game-FallBall object to store it in a variable.
     */
    public ModeMenu(FallBall game){
        this.game=game;
        background=new Texture("1stbackground.png");
        loadButtons();
        OrthographicCamera cam=new OrthographicCamera();
        Viewport viewport=new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        viewport.apply();
        cam.position.set(cam.viewportWidth/2,cam.viewportHeight/2,0);
        cam.update();
        stage=new Stage(viewport,game.getBatch());
        Gdx.input.setInputProcessor(stage);
    }

    /**
     * Function that gets all the textures needed to load the sprites.
     */
    private void loadButtons(){
        Texture levelTex=game.getAssetManager().get("LevelMode.png");
        levelSprite =new Sprite(levelTex,levelTex.getWidth(),levelTex.getHeight());
        levelSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*levelSprite.getHeight()/levelSprite.getWidth());
        Texture infiniteTex=game.getAssetManager().get("infinite.png");
        infiniteSprite =new Sprite(infiniteTex,infiniteTex.getWidth(),infiniteTex.getHeight());
        infiniteSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*infiniteSprite.getHeight()/infiniteSprite.getWidth());
        Texture returnTex=game.getAssetManager().get("return.png");
        returnSprite =new Sprite(returnTex,returnTex.getWidth(),returnTex.getHeight());
        returnSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*returnSprite.getHeight()/returnSprite.getWidth());

    }

    /**
     * Creates all the buttons needed to this menu.
     * Creates all the Listeners for those buttons.
     */
    @Override
    public void show(){
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        Drawable levelDrawable = new SpriteDrawable(levelSprite);
        ImageButton levelButton = new ImageButton(levelDrawable);
        Drawable infiniteDrawable = new SpriteDrawable(infiniteSprite);
        ImageButton infiniteButton = new ImageButton(infiniteDrawable);
        Drawable returnDrawable = new SpriteDrawable(returnSprite);
        ImageButton returnButton = new ImageButton(returnDrawable);

        levelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LevelMenu(game));
            }
        });
        infiniteButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        returnButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.MenuMusic.stop();
                game.setScreen(new MainMenu(game));
            }
        });
        table.add(levelButton).spaceBottom(100);
        table.row();
        table.add(infiniteButton).spaceBottom(100);
        table.row();
        table.add(returnButton);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.getBatch().end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        levelSprite.getTexture().dispose();
        infiniteSprite.getTexture().dispose();
        returnSprite.getTexture().dispose();
        background.dispose();
    }
}
