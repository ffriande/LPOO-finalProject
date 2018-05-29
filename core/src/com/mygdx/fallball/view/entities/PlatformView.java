package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.model.entities.EntityBaseModel;

public class PlatformView extends EntityBaseView {


    public PlatformView(FallBall game) {
        super(game);
    }

    public Sprite createSprite(FallBall game) {
        Texture texture = game.getAssetManager().get("platform.jpg");
        Sprite s= new Sprite(texture,texture.getWidth(), texture.getHeight());
        return s;
    }
}
