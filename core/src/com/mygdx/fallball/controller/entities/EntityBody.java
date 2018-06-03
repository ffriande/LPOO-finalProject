package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.EntityBaseModel;


public abstract class EntityBody {

    final Body body;

    EntityBody(World world, EntityBaseModel model, boolean isDynamic) {
        BodyDef bodyDef = new BodyDef();
        if (isDynamic)
            bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(model.getX(), model.getY());

        body = world.createBody(bodyDef);
        body.setUserData(model);
    }

    public float getX() {
        return body.getWorldCenter().x;
    }

    /**
     * Wraps the getY method from the Box2D body class.
     *
     * @return the y-coordinate of this body.
     */
    public float getY() {
        return body.getWorldCenter().y; //pode ter de ser mudado para getWorldCenter
    }

    public void setTransform(float x, float y) {
        body.setTransform(x, y, 0);
    }

    /**
     * Wraps the getUserData method from the Box2D body class.
     *
     * @return the user data
     */
    public Object getUserData() {
        return body.getUserData();
    }
}