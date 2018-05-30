package com.mygdx.fallball.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            /*float y=35/0.08f, x=0;
            for (int i = 0; i < 100; i++){
                x=0;
                if(i%10!=0){
                  PlatformModel platform = new NormalPlatformModel(x,y,5/0.08f,1/0.08f);
                  this.platforms.add(platform);}
                else{
                    PlatformModel platform = new RedPlatformModel(x,y,5/0.08f,1/0.08f, false);
                    this.platforms.add(platform);}
                }
                y-=10/0.08f;
                *//*if(x>=20/0.08f)
                    x=10/0.08f;
                else*//*
                x+=randomX();*/
        float y=30/0.08f, x=20/0.08f;
        for (int i = 0; i < 100; i++){
            PlatformModel platform = new NormalPlatformModel(x,y,5/0.08f,1/0.08f);
            this.platforms.add(platform);
            y-=10/0.08f;
            if(x>=40/0.08f)
                x=20/0.08f;
            else
                x+=10/0.08f;
        }
    }

    //TODO: fazer função auxiliar de randomize para o x das plataformas, tal como para as red plats

    private float randomX(){
        Random r = new Random();
        return (r.nextInt((10+1)+5)/0.08f);
    }


}
