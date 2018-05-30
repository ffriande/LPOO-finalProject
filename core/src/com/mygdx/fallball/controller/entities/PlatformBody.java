package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.PlatformModel;

public class PlatformBody extends EntityBody {
    public PlatformBody(World world, PlatformModel model, boolean isDynamic ) {
        super(world, model, false);
        createInertPlatformFixture(body, model.getWidth(),model.getHeight());
        }


    final void createInertPlatformFixture(Body body, float width, float height ) {
        PolygonShape plat = new PolygonShape();
        plat.setAsBox(width/2f, height/2f);
        body.createFixture(plat,0.0f);
        plat.dispose();
    }

}
