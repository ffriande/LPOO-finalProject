package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.fallball.FallBall;
/**
 * BallView.java-Ball view in game.
 * @see EntityBaseView
 */
public class BallView extends EntityBaseView {

    /**
     * Constructor of the class
     * @param g FallBall type . To get the asset used for the ball.
     */
    public BallView(FallBall g){
        super(g);
    }

    /**
     * Creates the ball sprite.
     * @param game Game which the view belongs.
     * @return Sprite created.
     */
    public Sprite createSprite(FallBall game) {
    Texture texture = game.getAssetManager().get("ball.png");
        return new Sprite(texture, texture.getWidth(), texture.getHeight());
    }
}
