package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.model.entities.EntityBaseModel;
import com.mygdx.fallball.model.entities.PlatformModel;

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
        sprite.setSize(Model.getInstance().getBall().getRadius(),Model.getInstance().getBall().getRadius());
        sprite.draw(batch);
    }
    public void draw(SpriteBatch batch, PlatformModel platformModel) {

      // sprite.setPosition(platformModel.getX(),platformModel.getY());
        sprite.setSize(platformModel.getWidth(),platformModel.getHeight());
        sprite.draw(batch);
    }

    public abstract Sprite createSprite(FallBall game);

    public void update(EntityBaseModel model) {
        sprite.setCenter(model.getX(), model.getY());
    }
    public void update(PlatformModel model) {
        sprite.setCenter(model.getX()+model.getWidth(), model.getY()+model.getHeight());
    }
}
