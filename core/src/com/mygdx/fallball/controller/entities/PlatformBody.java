package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;

public class PlatformBody extends EntityBody {

    private boolean isMoving;
    private float width;
    private float velocity;

    public PlatformBody(World world, PlatformModel model, boolean isKinematic) {
        super(world, model, isKinematic);
        float vel;
        if (model instanceof RedPlatformModel)
            if ((vel = ((RedPlatformModel) model).getVelocity()) != 0)
                this.velocity = vel;
        isMoving = isKinematic;
        this.width = model.getWidth();


        if (!isKinematic)
            createInertPlatformFixture(body, model.getWidth(), model.getHeight());
        else {
            createMovingPlatformFixture(body, model.getWidth(), model.getHeight());

        }

    }


    final void createInertPlatformFixture(Body body, float width, float height) {
        PolygonShape plat = new PolygonShape();
        plat.setAsBox(width / 2f, height / 2f);
        body.createFixture(plat, 0.0f);
        plat.dispose();
    }


    final void createMovingPlatformFixture(Body body, float width, float height) { //TODO:MUDAR ISTO
        PolygonShape plat = new PolygonShape();
        plat.setAsBox(width / 2f, height / 2f);
        body.createFixture(plat, 0.0f);
        plat.dispose();

    }

    /*
        public float getVelocity(){
            return body.getLinearVelocity( ).x;
        }
    */
    public void setVelocity(float vel) {
        this.velocity = vel;
    }

    public void moveRedPlat() {
        float rightEdgePos = this.getX() + width / 2;
        float leftEdgePos = this.getX() - width / 2;
        //3 mundos
        if (this.getX() < 0) {
            movePlats_aux(rightEdgePos, leftEdgePos, 1);
        } else if (this.getX() > VIEWPORT_WIDTH) {
            movePlats_aux(rightEdgePos, leftEdgePos, 3);
        } else {
            movePlats_aux(rightEdgePos, leftEdgePos, 2);
        }


    }

    public boolean isMoving() {
        return isMoving;
    }

    private void movePlats_aux(float rightEdgePos, float leftEdgePos, int world) {
        float midScreen = (-VIEWPORT_WIDTH / 2 + VIEWPORT_WIDTH * (world - 1));
        if (this.getX() >= midScreen) {
            if (rightEdgePos >= -VIEWPORT_WIDTH + VIEWPORT_WIDTH * world) {
                body.setLinearVelocity(-this.velocity, 0);
            } else if (leftEdgePos <= midScreen) {
                body.setLinearVelocity(this.velocity, 0);
            } else if (Math.abs(body.getLinearVelocity().x) != Math.abs(this.velocity)) //testa se ja tem vel
                body.setLinearVelocity(this.velocity, 0);
        } else if(this.getX() < midScreen){
            if (leftEdgePos <= -VIEWPORT_WIDTH + VIEWPORT_WIDTH * (world - 1)) {
                body.setLinearVelocity(this.velocity, 0);
            } else if (rightEdgePos >= midScreen) {
                body.setLinearVelocity(-this.velocity, 0);
            } else if (Math.abs(body.getLinearVelocity().x) != Math.abs(this.velocity))
                body.setLinearVelocity(this.velocity, 0);
        }
    }
}
