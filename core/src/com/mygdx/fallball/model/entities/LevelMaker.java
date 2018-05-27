package com.mygdx.fallball.model.entities;

import java.util.ArrayList;
import java.util.List;

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
            float y=10/0.02f, x=10/0.02f;
            for (int i = 0; i < 100; i++){
                PlatformModel platform = new NormalPlatformModel(x,y,5/0.02f,1/0.02f);
                this.platforms.add(platform);
                y-=10/0.02f;
                if(x>=20/0.02f)
                    x=10/0.02f;
                else
                    x+=10/0.02f;
        }
    }

    //TODO: fazer função auxiliar de randomize para o x das plataformas, tal como para as red plats
}
