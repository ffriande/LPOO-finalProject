package com.mygdx.fallball.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mygdx.fallball.view.View.PIXEL_TO_METER;

public class LevelMaker {



    private List<PlatformModel> platforms = new ArrayList<PlatformModel>();

    public LevelMaker(int dificulty){
        switch(dificulty){
            case 1:
                level1();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
    public List<PlatformModel> getPlatforms() {
        return platforms;
    }



    private void level1(){
            /*float y=35/PIXEL_TO_METER, x=0;
            for (int i = 0; i < 100; i++){
                x=0;
                if(i%10!=0){
                  PlatformModel platform = new NormalPlatformModel(x,y,5/PIXEL_TO_METER,1/PIXEL_TO_METER);
                  this.platforms.add(platform);}
                else{
                    PlatformModel platform = new RedPlatformModel(x,y,5/PIXEL_TO_METER,1/PIXEL_TO_METER, false);
                    this.platforms.add(platform);}
                }
                y-=10/PIXEL_TO_METER;
                *//*if(x>=20/PIXEL_TO_METER)
                    x=10/PIXEL_TO_METER;
                else*//*
                x+=randomX();*/
        float y=30, x=20;
        for (int i = 0; i < 100; i++){
            PlatformModel platform = new NormalPlatformModel(x,y,5,1);
            this.platforms.add(platform);
            y-=10;
            if(x>=40)
                x=20;
            else
                x+=10;
        }
    }

    //TODO: fazer função auxiliar de randomize para o x das plataformas, tal como para as red plats

    private float randomX(){
        Random r = new Random();
        return (r.nextInt((10+1)+5)/PIXEL_TO_METER);
    }


}
