package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.model.Model;

public class BallView extends EntityBaseView {

    public BallView(FallBall g){
        super(g);
    }

    public Sprite createSprite(FallBall game) {
    Texture texture = game.getAssetManager().get("ball.png");
        Sprite s= new Sprite(texture, texture.getWidth(), texture.getHeight());
        return s;
    }
}
