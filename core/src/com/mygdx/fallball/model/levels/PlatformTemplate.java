package com.mygdx.fallball.model.levels;


import com.mygdx.fallball.model.entities.PlatformModel;

import java.util.ArrayList;
import java.util.List;
/**
 * PlatformTemplate.java-Contains 1 template of a certain difficulty.
 */
public class PlatformTemplate{
    /**
     * List that contains all the platforms for this template.
     */
    private List<PlatformModel> platforms = new ArrayList<PlatformModel>();

    /**
     * Returns all the platforms.
     * @return this.platforms.
     */
    public List<PlatformModel> getPlatforms(){
        return platforms;
    }

    /**
     * Updates the y off all platforms.
     * @param y Y pretended to the first line of platforms.
     */
    public void setY(float y){
        for(PlatformModel it:platforms){
            it.setPos(it.getX(),(it.getY()+y));
        }
    }

    /**
     * Gets the y of the last line of platforms.
     * @return Type of float.
     */
    public float getLastY(){
        float y=0f;
        for(PlatformModel it:platforms){
            y=it.getY();
        }
        return y;
    }

    /**
     * Sets this.platforms to platforms.
     * @param platforms Type of List.
     */
    public void setPlatforms(List<PlatformModel> platforms){
        this.platforms=platforms;
    }


}
