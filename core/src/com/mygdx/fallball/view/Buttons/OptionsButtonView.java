package com.mygdx.fallball.view.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.fallball.FallBall;

public class OptionsButtonView extends ButtonView {
    public OptionsButtonView(float x,float y,float width){
        super(new Vector2(x,y),width);
    }


    @Override
    public void createTexture() {
        this.texture=new Texture("options.png");
    }

    @Override
    public void setScreen(FallBall game) {
        System.out.println("Falta meter menu options.");
    }

}
