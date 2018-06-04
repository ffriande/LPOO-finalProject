package com.mygdx.fallball.model.levels;

import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.PLATFORM_HEIGHT;

public class Level2Creator extends TemplateContainer {
    public Level2Creator(float x){
        super();
        createType1(x);
        createType2(x);
    }

    private void createType1(float x){
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        float y=0;
        RedPlatformModel n=new RedPlatformModel(x+7,y,5, PLATFORM_HEIGHT);
        plat.add(n);
        NormalPlatformModel n1=new NormalPlatformModel(x+29.5f,y,14, PLATFORM_HEIGHT);
        plat.add(n1);
        NormalPlatformModel n12=new NormalPlatformModel(x+45,y,10,PLATFORM_HEIGHT);
        plat.add(n12);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n2=new NormalPlatformModel(x+15,y,14, PLATFORM_HEIGHT);
        plat.add(n2);
        NormalPlatformModel n3=new NormalPlatformModel(x+42,y,16, PLATFORM_HEIGHT);
        plat.add(n3);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n6=new NormalPlatformModel(x+10,y,8, PLATFORM_HEIGHT);
        plat.add(n6);
        RedPlatformModel n7=new RedPlatformModel(x+24,y,8, PLATFORM_HEIGHT,5);
        plat.add(n7);
        RedPlatformModel n8=new RedPlatformModel(x+36f,y,20, PLATFORM_HEIGHT);
        plat.add(n8);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n4=new NormalPlatformModel(x+15,y,30, PLATFORM_HEIGHT);
        plat.add(n4);
        RedPlatformModel n5=new RedPlatformModel(x+38,y,10, PLATFORM_HEIGHT);
        plat.add(n5);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n9=new NormalPlatformModel(x+2.5f,y,5, PLATFORM_HEIGHT);
        plat.add(n9);
        RedPlatformModel n10=new RedPlatformModel(x+23f,y,16, PLATFORM_HEIGHT);
        plat.add(n10);
        RedPlatformModel n11=new RedPlatformModel(x+40f,y,10, PLATFORM_HEIGHT);
        plat.add(n11);
        p.setPlatforms(plat);
        templates.add(p);
    }

    private void createType2(float x){
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        float y=0;
        RedPlatformModel n=new RedPlatformModel(x+8,y,8, PLATFORM_HEIGHT);
        plat.add(n);
        NormalPlatformModel n1=new NormalPlatformModel(x+29.5f,y,14, PLATFORM_HEIGHT);
        plat.add(n1);
        NormalPlatformModel n12=new NormalPlatformModel(x+36.5f,y,10,PLATFORM_HEIGHT);
        plat.add(n12);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n2=new NormalPlatformModel(x+15,y,6, PLATFORM_HEIGHT);
        plat.add(n2);
        NormalPlatformModel n3=new NormalPlatformModel(x+42,y,16, PLATFORM_HEIGHT);
        plat.add(n3);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n6=new NormalPlatformModel(x+10,y,4, PLATFORM_HEIGHT);
        plat.add(n6);
        RedPlatformModel n7=new RedPlatformModel(x+20,y,8, PLATFORM_HEIGHT,5);
        plat.add(n7);
        RedPlatformModel n8=new RedPlatformModel(x+36f,y,18, PLATFORM_HEIGHT);
        plat.add(n8);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n4=new NormalPlatformModel(x+15,y,30, PLATFORM_HEIGHT);
        plat.add(n4);
        RedPlatformModel n5=new RedPlatformModel(x+40,y,20, PLATFORM_HEIGHT);
        plat.add(n5);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n9=new NormalPlatformModel(x+2.5f,y,5, PLATFORM_HEIGHT);
        plat.add(n9);
        RedPlatformModel n10=new RedPlatformModel(x+28f,y,8, PLATFORM_HEIGHT);
        plat.add(n10);
        NormalPlatformModel n13=new NormalPlatformModel(x+40f,y,8, PLATFORM_HEIGHT);
        plat.add(n13);
        p.setPlatforms(plat);
        templates.add(p);
    }
}
