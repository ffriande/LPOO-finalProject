package com.mygdx.fallball.model;


import com.mygdx.fallball.model.entities.BallModel;
import com.mygdx.fallball.model.entities.LevelMaker;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;

import java.util.ArrayList;
import java.util.List;

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
        ball= new BallModel(10/0.08f,40/0.08f,1/0.08f);

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
