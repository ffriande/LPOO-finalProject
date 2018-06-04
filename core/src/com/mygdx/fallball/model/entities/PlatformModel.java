package com.mygdx.fallball.model.entities;

/**
 * PlatformModel.java-Abstract class for all types of platforms.
 * @see EntityBaseModel
 */
public abstract class PlatformModel extends EntityBaseModel{
    /**
     * Width of the platform.
     */
    private float width;
    /**
     * Height of the platform.
     */
    private float height;

    /**
     * Constructor of the class.
     * @param x Coordinate in x.
     * @param y Coordinate in y.
     * @param width Width of the platform.
     * @param height Height of the platform.
     */
    public PlatformModel (float x,float y, float width, float height){
        super( x, y);
        this.width= width;
        this.height=height;
    }

    /**
     * Gets the width of this platform.
     * @return this.width.
     */
    public float getWidth(){
        return this.width;
    }
    /**
     * Gets the height of this platform.
     * @return this.height.
     */
    public float getHeight(){
        return this.height;
    }
}
