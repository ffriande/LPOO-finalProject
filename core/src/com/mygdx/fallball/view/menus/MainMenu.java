package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.view.Buttons.ButtonView;
import com.mygdx.fallball.view.Buttons.ExitButtonView;
import com.mygdx.fallball.view.Buttons.OptionsButtonView;
import com.mygdx.fallball.view.Buttons.StartButtonView;
import com.mygdx.fallball.view.View;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends ScreenAdapter {
    //TODO:Options menu
    //TODO:Select mode menu
    //TODO:Select level menu


    private FallBall game;
    List<ButtonView> buttons;

    public MainMenu(FallBall game){
        this.game=game;
        buttons=new ArrayList<ButtonView>();
        ButtonView startButton=new StartButtonView(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,500);
        buttons.add(startButton);
        ButtonView optionsButton=new OptionsButtonView(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2-250,500);
        buttons.add(optionsButton);
        ButtonView exitButton=new ExitButtonView(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2-500,500);
        buttons.add(exitButton);



    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isTouched()){
            for(ButtonView b : buttons){
                if(b.checkTouch(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY()))
                    b.setScreen(game);
            }

        }
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        for(ButtonView b : buttons)
           b.draw(game.getBatch());
        game.getBatch().end();
        //setScreen(new View(this));

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        for(ButtonView b : buttons)
            b.dispose();
    }
}
