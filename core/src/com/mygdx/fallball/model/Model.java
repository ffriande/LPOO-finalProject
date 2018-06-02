package com.mygdx.fallball.model;


import com.mygdx.fallball.model.entities.BallModel;
import com.mygdx.fallball.model.levels.LevelMaker;
import com.mygdx.fallball.model.entities.PlatformModel;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.FIRST_PLATFORM_Y;
import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;

public class Model {
    private static Model instance;

    private BallModel ball;

    private List<PlatformModel> platforms = new ArrayList<PlatformModel>();

    public static Model getInstance() {
        if (instance == null){
            instance = new Model();
            System.out.println("New instance of Model");}
        return instance;
    }

    Model(){
        ball= new BallModel(VIEWPORT_WIDTH/2f,FIRST_PLATFORM_Y+DISTANCE_BETWEEN_PLATFORMS,1.5f);

        platforms =new LevelMaker(1).getPlatforms();
    }

    public void setLevel(int i){
        ball= new BallModel(VIEWPORT_WIDTH/2f,FIRST_PLATFORM_Y+DISTANCE_BETWEEN_PLATFORMS,1.5f);
        platforms.clear();
        platforms= new LevelMaker(i).getPlatforms();
    }

    public BallModel getBall() {
        return ball;
    }

    public List<PlatformModel>  getPlatforms() {
        return platforms;
    }

    public void update( float x, float y) {
        ball.setPos(x,y);
    }

}
