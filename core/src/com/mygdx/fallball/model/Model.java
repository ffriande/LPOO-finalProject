package com.mygdx.fallball.model;


import com.mygdx.fallball.model.entities.BallModel;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;

public class Model {
    private static Model instance;

    private BallModel ball;

    private /*List<PlatformModel>*/ PlatformModel platforms;

    public static Model getInstance() {
        if (instance == null){
            instance = new Model();
            System.out.println("New instance of Model");}
        return instance;
    }

    Model(){
        ball= new BallModel(10/0.02f,30/0.02f,6f);  //TODO: ajustar valores aqui
        platforms = new NormalPlatformModel(-40,20,5,40); //TODO: e aqui

    }


    public BallModel getBall() {
        return ball;
    }

    public PlatformModel getPlatforms() {
        return platforms;
    }

    public void update( float x, float y) {
        ball.setPos(x,y);
    }

}
