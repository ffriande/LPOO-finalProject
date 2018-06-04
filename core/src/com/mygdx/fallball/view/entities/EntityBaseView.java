package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.model.entities.EntityBaseModel;
import com.mygdx.fallball.model.entities.PlatformModel;

import static com.mygdx.fallball.view.View.PIXEL_TO_METER;

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
        sprite.setSize(Model.getInstance().getBall().getRadius()*2/PIXEL_TO_METER,Model.getInstance().getBall().getRadius()*2/PIXEL_TO_METER);
        sprite.draw(batch);
    }
    public void draw(SpriteBatch batch, PlatformModel platformModel) {

      // sprite.setPosition(platformModel.getX(),platformModel.getY());
        sprite.setSize(platformModel.getWidth()/PIXEL_TO_METER,platformModel.getHeight()/PIXEL_TO_METER);
        sprite.draw(batch);
    }

    public abstract Sprite createSprite(FallBall game);

    public void update(EntityBaseModel model) {
        sprite.setPosition((model.getX()/PIXEL_TO_METER)-Model.getInstance().getBall().getRadius()/PIXEL_TO_METER, model.getY()/PIXEL_TO_METER-Model.getInstance().getBall().getRadius()/PIXEL_TO_METER);
    }
    public void update(PlatformModel model) {
        sprite.setPosition((model.getX()/PIXEL_TO_METER)-model.getWidth()/PIXEL_TO_METER/2f, model.getY()/PIXEL_TO_METER-model.getHeight()/PIXEL_TO_METER/2f);
    }
}
