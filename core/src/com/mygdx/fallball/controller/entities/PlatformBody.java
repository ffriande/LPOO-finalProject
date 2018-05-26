package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.PlatformModel;

public class PlatformBody extends EntityBody {
    public PlatformBody(World world, PlatformModel model, boolean isDynamic ) {
        super(world, model, false);
        createInertPlatformFixture(body, model.getWidth(),model.getHeight());
        }
}
