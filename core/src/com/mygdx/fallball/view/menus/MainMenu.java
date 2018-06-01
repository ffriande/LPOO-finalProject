package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
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
import com.mygdx.fallball.view.Buttons.ButtonView;
import com.mygdx.fallball.view.Buttons.ExitButtonView;
import com.mygdx.fallball.view.Buttons.OptionsButtonView;
import com.mygdx.fallball.view.Buttons.StartButtonView;
import com.mygdx.fallball.view.View;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Text;

public class MainMenu extends ScreenAdapter {
    //TODO:Options menu
    //TODO:Select mode menu
    //TODO:Select level menu
    public final static int ButtonsWidth = 500;


    private FallBall game;
    private Stage stage;
    private Sprite start;
    private Sprite options;
    private Sprite exit;
    private Texture background;
    private OrthographicCamera cam;
    private Viewport viewport;


    public MainMenu(FallBall game){
        this.game=game;
        background=new Texture("background.png");
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
        Texture startTex=new Texture("start.png");
        start=new Sprite(startTex,startTex.getWidth(),startTex.getHeight());
        start.setSize(ButtonsWidth,ButtonsWidth*start.getHeight()/start.getWidth());
        Texture optionsTex=new Texture("options.png");
        options=new Sprite(optionsTex,optionsTex.getWidth(),optionsTex.getHeight());
        options.setSize(ButtonsWidth,ButtonsWidth*options.getHeight()/options.getWidth());
        Texture exitTex=new Texture("exit.png");
        exit=new Sprite(exitTex,exitTex.getWidth(),exitTex.getHeight());
        exit.setSize(ButtonsWidth,ButtonsWidth*exit.getHeight()/exit.getWidth());

    }

    @Override
    public void show(){
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        Drawable startDrawable = new SpriteDrawable(start);
        ImageButton startButton = new ImageButton(startDrawable);
        Drawable optionsDrawable = new SpriteDrawable(options);
        ImageButton optionsButton = new ImageButton(optionsDrawable);
        Drawable exitDrawable = new SpriteDrawable(exit);
        ImageButton exitButton = new ImageButton(exitDrawable);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new ModeMenu(game));
            }
        });
        optionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //game.setScreen(new ModeMenu(game)); TODO:Meter options
            }
        });
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        table.add(startButton).spaceBottom(100);
        table.row();
        table.add(optionsButton).spaceBottom(100);
        table.row();
        table.add(exitButton).spaceBottom(100);
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
        background.dispose();
    }
}
