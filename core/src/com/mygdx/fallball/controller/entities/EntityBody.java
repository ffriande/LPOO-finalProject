package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.EntityBaseModel;


/**
 * Wrapper class that represents an abstract physical
 * body supported by a Box2D body.
 */
public abstract class EntityBody {
    /**
     * The box2d body
     */
    final Body body;

    /**
     * Abstract Constructor of the bodies of the game
     * @param world The world this body lives on.
     * @param model The model representing the body.
     * @param isKinetic Is the body kinetic
     */
    EntityBody(World world, EntityBaseModel model, boolean isKinetic) {
        BodyDef bodyDef = new BodyDef();
        if (isKinetic)
            bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(model.getX(), model.getY());

        body = world.createBody(bodyDef);
        body.setUserData(model);
    }

    /**
     * Wraps the getX method from the Box2D body class.
     * @return the x-coordinate of this body.
     */
    public float getX() {
        return body.getWorldCenter().x;
    }

    /**
     * Wraps the getY method from the Box2D body class.
     * @return the y-coordinate of this body.
     */
    public float getY() {
        return body.getWorldCenter().y; //pode ter de ser mudado para getWorldCenter
    }

    /**
     * Wraps the setTransform method from the Box2D body class.
     * @param x the new x-coordinate for this body
     * @param y the new y-coordinate for this body
     */
    public void setTransform(float x, float y) {
        body.setTransform(x, y, 0);
    }

    /**
     * Wraps the getUserData method from the Box2D body class.
     * @return the user data
     */
    public Object getUserData() {
        return body.getUserData();
    }
}