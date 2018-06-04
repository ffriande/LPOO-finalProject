package com.mygdx.fallball.model.entities;

/**
 * RedPlatformModel.java-Redplatform model.
 * @see PlatformModel
 */
public class RedPlatformModel extends PlatformModel{

    /**
     * Velocity that the platform moves.
     */
    private float velocity;
    /**
     * Boolean that says if the platform moves or not.
     */
    private boolean moving;

    /**
     * Constructor for the static red platfroms.
     * @param x Coordinate in x.
     * @param y Coordinate in y.
     * @param width Width of the platform.
     * @param height Height of the platform.
     */
    public RedPlatformModel(float x, float y, float width, float height){
        super(x,y,width,height);
        this.moving=false;
        this.velocity=0;
    }

    /**
     * Constructor for the moving red platfroms
     * @param x Coordinate in x.
     * @param y Coordinate in y.
     * @param width Width of the platform.
     * @param height Height of the platform.
     * @param velocity Velocity of the platform.
     */
    public RedPlatformModel(float x, float y, float width, float height, float  velocity){
        super(x,y,width,height);
        this.moving=true;
        this.velocity=velocity;
    }

    /**
     * Gets if the platform is moving.
     * @return this.moving.
     */
    public boolean getMoving() {
        return moving;
    }
    /**
     * Gets the velocity of the platform.
     * @return this.velocity.
     */
    public float getVelocity() {
        return velocity;
    }
}