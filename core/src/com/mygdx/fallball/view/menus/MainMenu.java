package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.fallball.FallBall;

public class MainMenu implements Screen {


    private FallBall game;
    //private Stage stage;
    Texture playButton;
    Texture exitButton;

    MainMenu(FallBall game){
        this.game=game;
        playButton = new Texture( "playButton.png");
        exitButton = new Texture( "exitButton.png");

    }

    @Override
    public void show() {




    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT);
    game.getBatch().begin();;

        game.getBatch().draw( ); //TODO:completar
        //setScreen(new View(this));

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
