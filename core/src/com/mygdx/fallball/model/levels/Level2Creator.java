package com.mygdx.fallball.model.levels;

import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.PLATFORM_HEIGHT;

public class Level2Creator extends TemplateContainer {
    public Level2Creator(){
        super();
        createType1();
    }

    public void createType1(){
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        float y=0;
        RedPlatformModel n=new RedPlatformModel(7,y,5, PLATFORM_HEIGHT);
        plat.add(n);
        NormalPlatformModel n1=new NormalPlatformModel(29.5f,y,14, PLATFORM_HEIGHT);
        plat.add(n1);
        NormalPlatformModel n12=new NormalPlatformModel(45,y,8,PLATFORM_HEIGHT);
        plat.add(n12);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n2=new NormalPlatformModel(15,y,6, PLATFORM_HEIGHT);
        plat.add(n2);
        NormalPlatformModel n3=new NormalPlatformModel(42,y,16, PLATFORM_HEIGHT);
        plat.add(n3);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n6=new NormalPlatformModel(10,y,4, PLATFORM_HEIGHT);
        plat.add(n6);
        RedPlatformModel n7=new RedPlatformModel(20,y,8, PLATFORM_HEIGHT,5);
        plat.add(n7);
        RedPlatformModel n8=new RedPlatformModel(36f,y,18, PLATFORM_HEIGHT);
        plat.add(n8);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n4=new NormalPlatformModel(15,y,30, PLATFORM_HEIGHT);
        plat.add(n4);
        RedPlatformModel n5=new RedPlatformModel(42,y,14, PLATFORM_HEIGHT);
        plat.add(n5);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n9=new NormalPlatformModel(2.5f,y,5, PLATFORM_HEIGHT);
        plat.add(n9);
        RedPlatformModel n10=new RedPlatformModel(18f,y,16, PLATFORM_HEIGHT);
        plat.add(n10);
        p.setPlatforms(plat);
        templates.add(p);
    }
}
