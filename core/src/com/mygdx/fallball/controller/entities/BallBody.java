package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.BallModel;

/**
 * Concrete representation of an EntityBody - the ball
 * @see EntityBody
 */
public class BallBody extends EntityBody {

    /**
     * Constructs a Ball's body
     * @param world The world this body lives on.
     * @param model The model representing the body.
     */
    public BallBody(World world, BallModel model) {
        super(world, model, false);
        float radius = model.getRadius(),
                density = 1f,
                friction = 0f,
                restitution = 1f;

        createBallFixture(body, radius, density, friction, restitution);
        body.setType(BodyDef.BodyType.DynamicBody);
    }

    /**
     * Creates ball's fixture (a circular shape)
     * @param body The body the fixture is to be attached to.
     * @param radius Radius of the circular shape.
     * @param density The density of the fixture. How heavy it is in relation to its area.
     * @param friction The friction of the fixture in relation to other bodies.
     * @param restitution The restitution of the fixture. How much it bounces.
     */
    private void createBallFixture(Body body, float radius, float density, float friction, float restitution) {
        CircleShape circle = new CircleShape();
        circle.setRadius(radius);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution;

        body.createFixture(fixtureDef);
        circle.dispose();
    }

    /**
     * Sets the linear velocity in x-axis to zero
     */
    public void setVelX_to_zero() {
        body.setLinearVelocity(0, body.getLinearVelocity().y);
    }

    /**
     * Sets linear velocity in y-axis to y
     * @param y Velocity in m/s.
     */
    public void setVelocity(double y) {
        body.setLinearVelocity(0, (float) y);
    }

    /**
     * Getter of the current linear velocity.
     * @return Vector2 of the linear velocity
     */
    public Vector2 getVelocity() {
        return body.getLinearVelocity();
    }
}
