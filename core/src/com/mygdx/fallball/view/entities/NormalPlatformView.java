package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.fallball.FallBall;
/**
 * NormalPlatformView.java-Normal platform view in game.
 * @see EntityBaseView
 */
public class NormalPlatformView extends EntityBaseView {

    /**
     * Constructor of the class
     * @param game FallBall type . To get the asset used for the normal platform.
     */
    public NormalPlatformView(FallBall game)     {
        super(game);
    }

    /**
     * Creates the normal platform sprite.
     * @param game Game which the view belongs.
     * @return Sprite created.
     */
    public Sprite createSprite(FallBall game) {
        Texture texture = game.getAssetManager().get("platform.png");
        return new Sprite(texture,texture.getWidth(), texture.getHeight());
    }
}
