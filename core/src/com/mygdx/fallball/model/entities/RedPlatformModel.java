package com.mygdx.fallball.model.entities;

public class RedPlatformModel extends PlatformModel implements java.io.Serializable{




    private float velocity;
    private boolean moving;
    public RedPlatformModel(float x, float y, float width, float height){
        super(x,y,width,height);
        this.moving=false;
        this.velocity=0;
    }

    public RedPlatformModel(float x, float y, float width, float height, float  velocity){
        super(x,y,width,height);
        this.moving=true;
        this.velocity=velocity;
    }
    public boolean getMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
    public float getVelocity() {
        return velocity;
    }
}