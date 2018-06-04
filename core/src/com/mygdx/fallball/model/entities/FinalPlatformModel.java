package com.mygdx.fallball.model.entities;

import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;

/**
 * Represents a model of the final platform in each level.
 */
public class FinalPlatformModel extends PlatformModel  {
    /**
     * Constructs a final platform, occupying the whole width of the screen.
     * @param x x-coordinate of the platform
     * @param y y-coordinate of the platform
     * @param height Height of the platform
     */
    public FinalPlatformModel(float x, float y, float height){
        super(x,y,VIEWPORT_WIDTH,height);
    }
}
