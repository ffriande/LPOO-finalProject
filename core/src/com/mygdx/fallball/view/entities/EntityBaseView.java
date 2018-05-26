package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.model.entities.EntityBaseModel;

public abstract class EntityBaseView {

    Sprite sprite;

    EntityBaseView(FallBall game) {
        sprite = createSprite(game);
    }

    /**
     * Draws the sprite from this view using a sprite batch.
     *
     * @param batch The sprite batch to be used for drawing.
     */
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public abstract Sprite createSprite(FallBall game);

    public void update(EntityBaseModel model) {
        sprite.setCenter(model.getX() , model.getY());
    }
}
