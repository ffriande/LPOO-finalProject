package com.mygdx.fallball.model.entities;

public abstract class EntityBaseModel implements java.io.Serializable{

    private float x;
    private float y;
    EntityBaseModel(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }
    public float getX() {
        return x;
    }
    public void setPos(float x, float y){
        this.x=x;
        this.y=y;
    }
}
