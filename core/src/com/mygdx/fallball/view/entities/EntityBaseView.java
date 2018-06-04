package com.mygdx.fallball.view.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.model.entities.EntityBaseModel;
import com.mygdx.fallball.model.entities.PlatformModel;

import static com.mygdx.fallball.view.View.PIXEL_TO_METER;
/**
 * A abstract view capable of holding a sprite with a certain
 * position and rotation.
 *
 * This view is able to update its data based on a entity model.
 */
public abstract class EntityBaseView {
    /**
     * Sprite of the entity.
     */
    private Sprite sprite;

    /**
     * Creates a view belonging to a game.
     *
     * @param game game which this view belongs.
     */
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

    /**
     * Abstract method to create this entity sprite.
     * @param game Game which the view belongs.
     * @return The spite created.
     */
    public abstract Sprite createSprite(FallBall game);

    /**
     * Updates the position of the sprite,used for the ball.
     * @param model Model used to update this sprite.
     */
    public void update(EntityBaseModel model) {
        sprite.setPosition((model.getX()/PIXEL_TO_METER)-Model.getInstance().getBall().getRadius()/PIXEL_TO_METER, model.getY()/PIXEL_TO_METER-Model.getInstance().getBall().getRadius()/PIXEL_TO_METER);
    }

    /**
     * Updates the position of the sprite.
     * @param model Model used to update this sprite.
     */
    public void update(PlatformModel model) {
        sprite.setPosition((model.getX()/PIXEL_TO_METER)-model.getWidth()/PIXEL_TO_METER/2f, model.getY()/PIXEL_TO_METER-model.getHeight()/PIXEL_TO_METER/2f);
    }
}
