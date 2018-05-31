package com.mygdx.fallball.view.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.view.View;

public class StartButtonView extends ButtonView {

    public StartButtonView(float x,float y,float width){
        super(new Vector2(x,y),width);
    }


    @Override
    public void createTexture() {
        this.texture=new Texture("start.png");
    }

    @Override
    public void setScreen(FallBall game) {
        game.setScreen(new View(game));
    }


}
