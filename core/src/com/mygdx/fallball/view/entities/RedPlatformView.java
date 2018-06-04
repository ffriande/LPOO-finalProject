package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.fallball.FallBall;
/**
 * RedPlatformView.java-Red platform view in game.
 * @see EntityBaseView
 */
public class RedPlatformView extends EntityBaseView {
    /**
     * Constructor of the class
     * @param game FallBall type . To get the asset used for the red platform.
     */
    public RedPlatformView(FallBall game)     {
        super(game);
    }
    /**
     * Creates the red platform sprite.
     * @param game Game which the view belongs.
     * @return Sprite created.
     */
    public Sprite createSprite(FallBall game) {
        Texture texture = game.getAssetManager().get("redplatform.png");
        return new Sprite(texture,texture.getWidth(), texture.getHeight());
    }
}
