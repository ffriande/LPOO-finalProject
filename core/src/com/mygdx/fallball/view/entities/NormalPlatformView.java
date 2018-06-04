package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.model.entities.EntityBaseModel;

public class NormalPlatformView extends EntityBaseView {


    public NormalPlatformView(FallBall game)     {
        super(game);
    }

    public Sprite createSprite(FallBall game) {
        Texture texture = game.getAssetManager().get("platform.png");
        return new Sprite(texture,texture.getWidth(), texture.getHeight());
    }
}
