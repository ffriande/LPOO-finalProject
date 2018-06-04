package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;
/**
 * Concrete representation of an EntityBody - a platform
 * @see EntityBody
 */
public class PlatformBody extends EntityBody {
    /**
     * Boolean of the platform's ability to move
     */
    private boolean isMoving;
    /**
     * Platform's width.
     */
    private float width;
    /**
     * Intended platform's velocity.
     */
    private float velocity;

    /**
     * Constructs a Platform's body
     * @param world The world this body lives on.
     * @param model The model representing the body.
     * @param isKinematic Is the body movable.
     */
    public PlatformBody(World world, PlatformModel model, boolean isKinematic) {
        super(world, model, isKinematic);
        float vel;
        if (model instanceof RedPlatformModel)
            if ((vel = ((RedPlatformModel) model).getVelocity()) != 0)
                this.velocity = vel;
        isMoving = isKinematic;
        this.width = model.getWidth();

        createPlatformFixture(body, model.getWidth(), model.getHeight());
    }

    /**
     * Creates a fixture for the Platform - a rectangular shape.
     * @param body Body it is attached to.
     * @param width Width of the fixture.
     * @param height Height of the fixture.
     */
     private final void createPlatformFixture(Body body, float width, float height) {
        PolygonShape plat = new PolygonShape();
        plat.setAsBox(width / 2f, height / 2f);
        body.createFixture(plat, 0.0f);
        plat.dispose();
    }

    /**
     * Moves the platform according to it's velocity.
     */
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

    /**
     * Auxiliar function to move the platform.
     * @param rightEdgePos Position (x) of the right edge of the platform
     * @param leftEdgePos Position (x) of the left edge of the platform
     * @param world Number of the world (1,2 or 3)
     */
    private void movePlats_aux(float rightEdgePos, float leftEdgePos, int world) {
        float midScreen = (-VIEWPORT_WIDTH / 2 + VIEWPORT_WIDTH * (world - 1));
        if (this.getX() >= midScreen) {
            if (rightEdgePos >= -VIEWPORT_WIDTH + VIEWPORT_WIDTH * world) {
                body.setLinearVelocity(-this.velocity, 0);
            } else if (leftEdgePos <= midScreen) {
                body.setLinearVelocity(this.velocity, 0);
            } else if (Math.abs(body.getLinearVelocity().x) != Math.abs(this.velocity)) //testa se ja tem vel
                body.setLinearVelocity(this.velocity, 0);
        } else if (this.getX() < midScreen) {
            if (leftEdgePos <= -VIEWPORT_WIDTH + VIEWPORT_WIDTH * (world - 1)) {
                body.setLinearVelocity(this.velocity, 0);
            } else if (rightEdgePos >= midScreen) {
                body.setLinearVelocity(-this.velocity, 0);
            } else if (Math.abs(body.getLinearVelocity().x) != Math.abs(this.velocity))
                body.setLinearVelocity(this.velocity, 0);
        }
    }

    /**
     * Getter of the variable isMoving
     * @return Boolean of the platform's ability to move
     */
    public boolean isMoving() {
        return isMoving;
    }

}
