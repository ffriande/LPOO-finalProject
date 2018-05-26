package com.mygdx.fallball.model.entities;

public class RedPlatformModel extends PlatformModel {


    private boolean moving;
    public RedPlatformModel(float x, float y, float width, float height, boolean moving){
        super(x,y,width,height);
        this.moving=moving;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
