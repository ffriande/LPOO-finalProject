package com.mygdx.fallball.model.levels;

import com.mygdx.fallball.model.entities.PlatformModel;

import java.util.ArrayList;
import java.util.List;

public class PlatformTemplate implements java.io.Serializable{
    private float y;
    private List<PlatformModel> platforms = new ArrayList<PlatformModel>();

    public PlatformTemplate(){

    }
    public List<PlatformModel> getPlatforms(){
        return platforms;
    }
    public void setY(float y){
        for(PlatformModel it:platforms){
            it.setPos(it.getX(),(it.getY()+y));
        }
    }

    public void setPlatforms(List<PlatformModel> platforms){
        this.platforms=platforms;
    }
}
