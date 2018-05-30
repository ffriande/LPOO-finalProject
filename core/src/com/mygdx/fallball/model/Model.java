package com.mygdx.fallball.model;


import com.mygdx.fallball.model.entities.BallModel;
import com.mygdx.fallball.model.entities.LevelMaker;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.view.View.PIXEL_TO_METER;
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
        ball= new BallModel(VIEWPORT_WIDTH/2f,(VIEWPORT_WIDTH),1);

        platforms =new LevelMaker(1).getPlatforms();
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
