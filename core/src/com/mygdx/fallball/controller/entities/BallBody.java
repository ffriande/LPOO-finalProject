package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.BallModel;

public class BallBody extends EntityBody {
    public BallBody(World world, BallModel model, boolean isDynamic) {
            super(world, model, true);
        float   radius = model.getRadius(),
                density = 1f,
                friction = 0f,
                restitution = 1f;

        createBallFixture(body, radius, density, friction, restitution);

    }
    public void applyImpulse(float impulseY){
        body.applyLinearImpulse(0,impulseY,this.getX(),this.getY(), true);
    }

    public Vector2 getVelocity(){
        return body.getLinearVelocity();
    }
}
