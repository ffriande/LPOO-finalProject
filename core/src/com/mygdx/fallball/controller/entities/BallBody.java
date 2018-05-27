package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.BallModel;

public class BallBody extends EntityBody {
    public BallBody(World world, BallModel model, boolean isDynamic) {
            super(world, model, true);
        float   radius = model.getRadius(),
                density = 1f,
                friction = 0.4f,
                restitution = 1f;

        createBallFixture(body, radius, density, friction, restitution);

    }
}
