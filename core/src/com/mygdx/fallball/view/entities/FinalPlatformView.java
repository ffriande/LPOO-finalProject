package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.fallball.FallBall;

public class FinalPlatformView extends EntityBaseView {
    public FinalPlatformView(FallBall game)     {
        super(game);
    }

    public Sprite createSprite(FallBall game) {
        Texture texture = game.getAssetManager().get("finalplatform.png");
        Sprite s= new Sprite(texture,texture.getWidth(), texture.getHeight());
        return s;
    }
}
