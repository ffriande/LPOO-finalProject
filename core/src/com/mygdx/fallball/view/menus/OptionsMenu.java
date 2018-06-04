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
import com.mygdx.fallball.view.View;

/**
 * OptionsMenu.java-Menu to change some game options.
 * You can change sound(mute/unmute).
 * You can reset the levels to standard.
 * @see ScreenAdapter
 */
public class OptionsMenu extends ScreenAdapter {
    private FallBall game;
    private Stage stage;
    private Sprite MuteSprite;
    private Sprite returnSprite;
    private Sprite ResetSprite;
    private Texture background;

    /**
     * Class constructor.
     * Inicializes all the class variables.
     * Creates camara and viewport.
     * Loads all the spites needed.
     * @param game-FallBall object to store it in a variable.
     */
    public OptionsMenu(FallBall game){
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
        Texture MuteTex=game.getAssetManager().get("sound.png");
        MuteSprite =new Sprite(MuteTex,MuteTex.getWidth(),MuteTex.getHeight());
        MuteSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*MuteSprite.getHeight()/MuteSprite.getWidth());
        Texture returnTex=game.getAssetManager().get("return.png");
        returnSprite =new Sprite(returnTex,returnTex.getWidth(),returnTex.getHeight());
        returnSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*returnSprite.getHeight()/returnSprite.getWidth());
        Texture resetTex=game.getAssetManager().get("reset.png");
        ResetSprite =new Sprite(resetTex,resetTex.getWidth(),resetTex.getHeight());
        ResetSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*ResetSprite.getHeight()/ResetSprite.getWidth());

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

        final Drawable muteDrawable = new SpriteDrawable(MuteSprite);
        ImageButton muteButton = new ImageButton(muteDrawable);
        Drawable returnDrawable = new SpriteDrawable(returnSprite);
        ImageButton returnButton = new ImageButton(returnDrawable);
        Drawable resetDrawable = new SpriteDrawable(ResetSprite);
        ImageButton resetButton = new ImageButton(resetDrawable);

        resetButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Levels.getInstance().resetLevels();
                MainMenu.MenuMusic.stop();
                game.setScreen(new MainMenu(game));
            }
        });
        muteButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(View.VOLUME==0f){
                    View.VOLUME=1f;
                    MainMenu.MenuMusic.loop(View.VOLUME/2f);
                }else {
                    MainMenu.MenuMusic.stop();
                    View.VOLUME = 0f;
                }
            }
        });
        returnButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.MenuMusic.stop();
                game.setScreen(new MainMenu(game));
            }
        });
        table.add(muteButton).spaceBottom(100);
        table.row();
        table.add(resetButton).spaceBottom(100);
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
        background.dispose();
        MuteSprite.getTexture().dispose();
        returnSprite.getTexture().dispose();
        ResetSprite.getTexture().dispose();

    }
}
