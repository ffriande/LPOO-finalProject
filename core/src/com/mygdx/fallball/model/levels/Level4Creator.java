package com.mygdx.fallball.model.levels;

import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.PLATFORM_HEIGHT;

public class Level4Creator extends TemplateContainer {
    public Level4Creator(float x){
        super();
        createType1(x);
    }

    private void createType1(float x){
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        float y=0;
        RedPlatformModel n=new RedPlatformModel(x+10,y,7.5f, PLATFORM_HEIGHT,5);
        plat.add(n);
        RedPlatformModel n1=new RedPlatformModel(x+21.25f,y,2.5f, DISTANCE_BETWEEN_PLATFORMS-PLATFORM_HEIGHT/2);
        plat.add(n1);
        NormalPlatformModel n12=new NormalPlatformModel(x+26.25f,y,7.5f,PLATFORM_HEIGHT);
        plat.add(n12);
        RedPlatformModel n13=new RedPlatformModel(x+33.75f,y,7.5f,PLATFORM_HEIGHT);
        plat.add(n13);
        NormalPlatformModel n14=new NormalPlatformModel(x+47.5f,y,5f,PLATFORM_HEIGHT);
        plat.add(n14);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n2=new NormalPlatformModel(x+7.5f,y,15, PLATFORM_HEIGHT);
        plat.add(n2);
        RedPlatformModel n3=new RedPlatformModel(x+23.75f,y,7.5f, PLATFORM_HEIGHT);
        plat.add(n3);
        NormalPlatformModel n15=new NormalPlatformModel(x+33.75f,y,15, PLATFORM_HEIGHT);
        plat.add(n15);
        RedPlatformModel n16=new RedPlatformModel(x+45f,y,7.5f, PLATFORM_HEIGHT);
        plat.add(n16);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n6=new NormalPlatformModel(x+17.5f,y,5f, PLATFORM_HEIGHT);
        plat.add(n6);
        RedPlatformModel n7=new RedPlatformModel(x+5f,y,5f, PLATFORM_HEIGHT,15);
        plat.add(n7);
        RedPlatformModel n8=new RedPlatformModel(x+45f,y,5f, PLATFORM_HEIGHT,15);
        plat.add(n8);
        NormalPlatformModel n17=new NormalPlatformModel(x+40f,y,10f, PLATFORM_HEIGHT);
        plat.add(n17);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n4=new NormalPlatformModel(x+5f,y,5f, PLATFORM_HEIGHT);
        plat.add(n4);
        RedPlatformModel n5=new RedPlatformModel(x+16.25f,y,2.5f, DISTANCE_BETWEEN_PLATFORMS-PLATFORM_HEIGHT/2);
        plat.add(n5);
        RedPlatformModel n18=new RedPlatformModel(x+25f,y,10f, PLATFORM_HEIGHT);
        plat.add(n18);
        NormalPlatformModel n19=new NormalPlatformModel(x+35f,y,10f, PLATFORM_HEIGHT);
        plat.add(n19);
        RedPlatformModel n20=new RedPlatformModel(x+47.5f,y,5f, PLATFORM_HEIGHT);
        plat.add(n20);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n9=new NormalPlatformModel(x+12.5f,y,15f, PLATFORM_HEIGHT);
        plat.add(n9);
        RedPlatformModel n10=new RedPlatformModel(x+25f,y,10f, PLATFORM_HEIGHT);
        plat.add(n10);
        RedPlatformModel n21=new RedPlatformModel(x+45f,y,5f, PLATFORM_HEIGHT,10);
        plat.add(n21);
        p.setPlatforms(plat);
        templates.add(p);
    }

    private void createType2(float x){
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        float y=0;
        RedPlatformModel n=new RedPlatformModel(x+10,y,10f, PLATFORM_HEIGHT,10);
        plat.add(n);
        NormalPlatformModel n1=new NormalPlatformModel(x+2.5f,y,5f, PLATFORM_HEIGHT);
        plat.add(n1);
        NormalPlatformModel n12=new NormalPlatformModel(x+30,y,10f,PLATFORM_HEIGHT);
        plat.add(n12);
        RedPlatformModel n13=new RedPlatformModel(x+40,y,10f, PLATFORM_HEIGHT,5);
        plat.add(n13);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n2=new NormalPlatformModel(x+10,y,10f, PLATFORM_HEIGHT);
        plat.add(n2);
        RedPlatformModel n14=new RedPlatformModel(x+30,y,20f, PLATFORM_HEIGHT,2.5f);
        plat.add(n14);
        NormalPlatformModel n3=new NormalPlatformModel(x+45,y,8, PLATFORM_HEIGHT);
        plat.add(n3);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n6=new NormalPlatformModel(x+10,y,4, PLATFORM_HEIGHT);
        plat.add(n6);
        RedPlatformModel n7=new RedPlatformModel(x+20,y,8, PLATFORM_HEIGHT,5);
        plat.add(n7);
        RedPlatformModel n8=new RedPlatformModel(x+36f,y,18, PLATFORM_HEIGHT);
        plat.add(n8);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n4=new NormalPlatformModel(x+5,y,10, PLATFORM_HEIGHT);
        plat.add(n4);
        RedPlatformModel n5=new RedPlatformModel(x+42,y,14, PLATFORM_HEIGHT,6);
        plat.add(n5);
        RedPlatformModel n15=new RedPlatformModel(x+15,y,10, PLATFORM_HEIGHT);
        plat.add(n15);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n9=new NormalPlatformModel(x+2.5f,y,5, PLATFORM_HEIGHT);
        plat.add(n9);
        RedPlatformModel n10=new RedPlatformModel(x+18f,y,16, PLATFORM_HEIGHT);
        plat.add(n10);
        RedPlatformModel n20=new RedPlatformModel(x+42,y,10, PLATFORM_HEIGHT,20);
        plat.add(n20);
        p.setPlatforms(plat);
        templates.add(p);
    }
}
