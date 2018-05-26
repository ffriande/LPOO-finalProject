package com.mygdx.fallball.model.entities;

public class BallModel extends EntityBaseModel {



    private boolean falling;
    private float jumpHeight;
    private float maxVelocity;



    private float radius;

    public BallModel(float x, float y, float radius) {
        super(x, y);
        this.radius=radius;
        falling = true;
        jumpHeight = 10;//TODO: mudar estes valores
        maxVelocity = 2.1f;//mudar
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }
    public float getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public float getMaxVelocity() {
        return maxVelocity;
    }

    public void setMaxVelocity(float maxVelocity) {
        this.maxVelocity = maxVelocity;
    }
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
