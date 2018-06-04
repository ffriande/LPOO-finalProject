package com.mygdx.fallball.model.entities;


public abstract class PlatformModel extends EntityBaseModel{
    private float width;
    private float height;

    public PlatformModel (float x,float y, float width, float height){
        super( x, y);
        this.width= width;
        this.height=height;
    }

    public float getWidth(){
        return this.width;
    }
    public float getHeight(){
        return this.height;
    }
}
