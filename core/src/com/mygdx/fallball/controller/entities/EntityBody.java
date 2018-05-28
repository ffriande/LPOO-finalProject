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
            bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(model.getX(), model.getY());

        body = world.createBody(bodyDef);
        body.setUserData(model);
    }



    final void createBallFixture(Body body,float radius, float density, float friction, float restitution/*,short category, short mask */ ) {


        CircleShape circle = new CircleShape();
        circle.setRadius(radius);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution; // Make it bounce a little bit



     /*   fixtureDef.filter.categoryBits = category; //filter is for not to happen collision acho eu
        fixtureDef.filter.maskBits = mask;
        */


        body.createFixture(fixtureDef);

        circle.dispose();
    }

    final void createInertPlatformFixture(Body body, float width, float height ) {
        PolygonShape plat = new PolygonShape();
        plat.setAsBox(width, height);
        body.createFixture(plat,0.0f);
        plat.dispose();
    }


    public float getX() {
        return body.getWorldCenter().x;  //pode ter de ser mudado para getWorldCenter
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
     * Wraps the applyForceToCenter method from the Box2D body class.
     *
     * @param forceX the x-component of the force to be applied
     * @param forceY the y-component of the force to be applied
     * @param awake  should the body be awaken
     */
    public void applyForceToCenter(float forceX, float forceY, boolean awake) {
        body.applyForceToCenter(forceX, forceY, awake);
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