package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.fallball.FallBall;

public class RedPlatformView extends EntityBaseView {
    public RedPlatformView(FallBall game)     {
        super(game);
    }

    public Sprite createSprite(FallBall game) {
        Texture texture = game.getAssetManager().get("redplatform.png");
        return new Sprite(texture,texture.getWidth(), texture.getHeight());
    }
}
