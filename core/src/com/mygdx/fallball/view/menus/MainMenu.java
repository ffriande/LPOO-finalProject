package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
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
import com.mygdx.fallball.view.View;

/**
 * MainMenu.java-First screen to appear , Main menu screen.
 * Has the music to be played in the menu screens.
 * @see ScreenAdapter
 */
public class MainMenu extends ScreenAdapter {
    public final static int ButtonsWidth = 500;


    private FallBall game;
    private Stage stage;
    private Sprite start;
    private Sprite options;
    private Sprite exit;
    private Texture background;
    public static Sound MenuMusic=Gdx.audio.newSound(Gdx.files.internal("music.wav"));

    /**
     * Class constructor.
     * Inicializes all the class variables.
     * Creates camara and viewport.
     * Loads all the spites needed.
     * @param game-FallBall object to store it in a variable.
     */
    public MainMenu(FallBall game){
        this.game=game;
        background=new Texture("1stbackground.png");
        MenuMusic.loop(View.VOLUME/2f);
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
        Texture startTex=game.getAssetManager().get("start.png");
        start=new Sprite(startTex,startTex.getWidth(),startTex.getHeight());
        start.setSize(ButtonsWidth,ButtonsWidth*start.getHeight()/start.getWidth());
        Texture optionsTex=game.getAssetManager().get("options.png");
        options=new Sprite(optionsTex,optionsTex.getWidth(),optionsTex.getHeight());
        options.setSize(ButtonsWidth,ButtonsWidth*options.getHeight()/options.getWidth());
        Texture exitTex=game.getAssetManager().get("exit.png");
        exit=new Sprite(exitTex,exitTex.getWidth(),exitTex.getHeight());
        exit.setSize(ButtonsWidth,ButtonsWidth*exit.getHeight()/exit.getWidth());

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

        Drawable startDrawable = new SpriteDrawable(start);
        final ImageButton startButton = new ImageButton(startDrawable);
        Drawable optionsDrawable = new SpriteDrawable(options);
        final ImageButton optionsButton = new ImageButton(optionsDrawable);
        Drawable exitDrawable = new SpriteDrawable(exit);
        final ImageButton exitButton = new ImageButton(exitDrawable);


        table.add(startButton).spaceBottom(100);
        table.row();
        table.add(optionsButton).spaceBottom(100);
        table.row();
        table.add(exitButton).spaceBottom(100);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new ModeMenu(game));
            }
        });
        optionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new OptionsMenu(game));
            }
        });
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
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
        background.dispose();
        start.getTexture().dispose();
        options.getTexture().dispose();
        exit.getTexture().dispose();
    }
}
