package com.mygdx.fallball.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mygdx.fallball.view.View.PIXEL_TO_METER;
import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;

public class LevelMaker {
    public final static float DISTANCE_BETWEEN_PLATFORMS = 20;
    public final static float FIRST_PLATFORM_Y = 25;



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
        float width=5;
        float y=FIRST_PLATFORM_Y, x=width/2f;//ter a certeza que nao fica de fora
//        for (int j = 0; j < 3; j++){//3 mundos
//            x=-VIEWPORT_WIDTH+width/2f+VIEWPORT_WIDTH*j;
//            y=FIRST_PLATFORM_Y;
        for (int i = 0; i < 5; i++){
                       //3 mundos
            PlatformModel platform;

          if(y==5 || y==-15)
                platform = new RedPlatformModel(x,y,width,1,4f);
            else if(i==4)
                 platform=new FinalPlatformModel(VIEWPORT_WIDTH/2,y,3  );
            else
                platform = new NormalPlatformModel(x,y,width,1);

            this.platforms.add(platform);
            x+=width; //step do x
            y-=DISTANCE_BETWEEN_PLATFORMS;
//                if(j==0)
//                    if(x+width/2f>=0){
//                        System.out.println("\n\n\nPROXIMA LINHA j=0");
//                    x=-VIEWPORT_WIDTH+width/2f+VIEWPORT_WIDTH*j;
//                        continue;}
//                else if(j==1)
                    if(x+width/2f>=VIEWPORT_WIDTH){
                    System.out.println("\n\n\nPROXIMA LINHA j=1");
                        x=width/2f;
                        }
//                else{
//                    if(x+width/2f>=VIEWPORT_WIDTH*2){
//                        System.out.println("\n\n\nPROXIMA LINHA j=2");
//                        x=-VIEWPORT_WIDTH+width/2f+VIEWPORT_WIDTH*j;
//                continue;}}
//        }
        //3 mundos
        }
    }

    //TODO: fazer função auxiliar de randomize para o x das plataformas, tal como para as red plats

    private float randomX(){
        Random r = new Random();
        return (r.nextInt((10+1)+5)/PIXEL_TO_METER);
    }


}
