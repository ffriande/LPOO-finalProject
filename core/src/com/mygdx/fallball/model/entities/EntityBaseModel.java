package com.mygdx.fallball.model.entities;

/**
 * An abstract model representing an entity belonging to a game model.
 */
public abstract class EntityBaseModel{
    /**
     * X-axis position, in meters
     */
    private float x;
    /**
     * Y-axis position, in meters
     */
    private float y;

    /**
     * Constructs a model with a position in meters.
     *
     * @param x The x-coordinate of this entity in meters.
     * @param y The y-coordinate of this entity in meters.
     */
    EntityBaseModel(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the y-coordinate of this entity.
     *
     * @return The y-coordinate of this entity in meters.
     */
    public float getY() {
        return y;
    }
    /**
     * Returns the x-coordinate of this entity.
     *
     * @return The x-coordinate of this entity in meters.
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the position of this entity.
     *
     * @param x The x-coordinate of this entity in meters.
     * @param y The y-coordinate of this entity in meters.
     */
    public void setPos(float x, float y){
        this.x=x;
        this.y=y;
    }
}
