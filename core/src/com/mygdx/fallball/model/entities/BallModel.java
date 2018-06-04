package com.mygdx.fallball.model.entities;

/***
 * Represents a model of the ball
 * @see EntityBaseModel
 */
public class BallModel extends EntityBaseModel {
    /**
     * ´Radius of the ball.
     */
    private float radius;

    /**
     * Constructor of the model of the ball
     * @param x Position of the ball (x-axis)
     * @param y Position of the ball (y-axis)
     * @param radius Radius of the ball
     */
    public BallModel(float x, float y, float radius) {
        super(x, y);
        this.radius=radius;
    }

    /**
     * Getter of the ball's radius
     * @return Ball's radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Setter of the ball's radius.
     * @param radius radius to be set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }
}
