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
 * WinMenu.java-Menu that appears when a level is completed.
 * @see ScreenAdapter
 */
public class WinMenu extends ScreenAdapter {
    /**
     * The game this screen belongs to.
     */
    private FallBall game;
    /**
     * Used to set buttons to the screen.
     */
    private Stage stage;
    /**
     * Sprite of Main menu button.
     */
    private Sprite mainMenuS;
    /**
     * Sprite of Level Menu button.
     */
    private Sprite levelS;
    /**
     * Background of this view.
     */
    private Texture background;


    /**
     * Class constructor.
     * Inicializes all the class variables.
     * Creates camara and viewport.
     * Loads all the spites needed.
     * @param game-FallBall object to store it in a variable.
     */
    public WinMenu(FallBall game){
        this.game=game;
        background=game.getAssetManager().get("winback.png");
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
        levelS=new Sprite(levelTex,levelTex.getWidth(),levelTex.getHeight());
        levelS.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*levelS.getHeight()/levelS.getWidth());
        Texture continueTex=game.getAssetManager().get("MainMenu.png");
        mainMenuS =new Sprite(continueTex,continueTex.getWidth(),continueTex.getHeight());
        mainMenuS.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth* mainMenuS.getHeight()/ mainMenuS.getWidth());


    }

    /**
     * Creates all the buttons needed to this menu.
     * Creates all the Listeners for those buttons.
     */
    @Override
    public void show(){
        Table table = new Table();
        table.setFillParent(true);

        Drawable levelDrawable = new SpriteDrawable(levelS);
        ImageButton levelButton = new ImageButton(levelDrawable);
        Drawable mainMenuDrawable = new SpriteDrawable(mainMenuS);
        ImageButton mainMenuButton = new ImageButton(mainMenuDrawable);

        levelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LevelMenu(game));
            }
        });
        mainMenuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.MenuMusic.stop();
                game.setScreen(new MainMenu(game));
            }
        });

        table.add(levelButton).spaceBottom(100);
        table.row();
        table.add(mainMenuButton);

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
        mainMenuS.getTexture().dispose();
        levelS.getTexture().dispose();
        background.dispose();
    }
}
