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
import com.mygdx.fallball.controller.Controller;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.view.View;

public class ModeMenu extends ScreenAdapter {
    private FallBall game;
    private Stage stage;
    private Sprite levelSprite;
    private Sprite infiniteSprite;
    private Sprite returnSprite;
    private Texture background;
    private OrthographicCamera cam;
    private Viewport viewport;


    public ModeMenu(FallBall game){
        this.game=game;
        background=new Texture("1stbackground.png");
        loadButtons();
        cam=new OrthographicCamera();
        viewport=new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        viewport.apply();
        cam.position.set(cam.viewportWidth/2,cam.viewportHeight/2,0);
        cam.update();
        stage=new Stage(viewport,game.getBatch());
        Gdx.input.setInputProcessor(stage);





    }



    public void loadButtons(){
        Texture levelTex=new Texture("LevelMode.png");
        levelSprite =new Sprite(levelTex,levelTex.getWidth(),levelTex.getHeight());
        levelSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*levelSprite.getHeight()/levelSprite.getWidth());
        Texture infiniteTex=new Texture("infinite.png");
        infiniteSprite =new Sprite(infiniteTex,infiniteTex.getWidth(),infiniteTex.getHeight());
        infiniteSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*infiniteSprite.getHeight()/infiniteSprite.getWidth());
        Texture returnTex=new Texture("return.png");
        returnSprite =new Sprite(returnTex,returnTex.getWidth(),returnTex.getHeight());
        returnSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*returnSprite.getHeight()/returnSprite.getWidth());

    }

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
                //game.setScreen(new MainMenu(game));TODO:meter o screen no modo infinito
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

        //setScreen(new View(this));

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
