package com.mygdx.fallball.model.entities;

public class BallModel extends EntityBaseModel {
    private float radius;

    public BallModel(float x, float y, float radius) {
        super(x, y);
        this.radius=radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
