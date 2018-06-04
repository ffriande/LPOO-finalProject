package com.mygdx.fallball.model.levels;

import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.PLATFORM_HEIGHT;


/**
 * Level3Creator.java-Creates all the templates of difficulty 3.
 * @see TemplateContainer
 */
public class Level3Creator extends TemplateContainer {

    /**
     * Class constructor.
     * Calls the functions to create the templates
     * @param x Used for the 3 worlds creation.
     */
    public Level3Creator(float x){
        super();
        createType1(x);
        createType2(x);
    }
    /**
     * Creates the type1 template off this difficulty.
     * @param x Used for the 3 worlds creation.
     */
    private void createType1(float x){
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        float y=0;
        RedPlatformModel n=new RedPlatformModel(x+7,y,5, PLATFORM_HEIGHT,8);
        plat.add(n);
        NormalPlatformModel n1=new NormalPlatformModel(x+29.5f,y,14, PLATFORM_HEIGHT);
        plat.add(n1);
        RedPlatformModel n12=new RedPlatformModel(x+45,y,8,PLATFORM_HEIGHT);
        plat.add(n12);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        RedPlatformModel n2=new RedPlatformModel(x+15,y,6, PLATFORM_HEIGHT);
        plat.add(n2);
        NormalPlatformModel n3=new NormalPlatformModel(x+42,y,16, PLATFORM_HEIGHT);
        plat.add(n3);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n6=new NormalPlatformModel(x+10,y,4, PLATFORM_HEIGHT);
        plat.add(n6);
        RedPlatformModel n7=new RedPlatformModel(x+20,y,8, PLATFORM_HEIGHT,5);
        plat.add(n7);
        RedPlatformModel n8=new RedPlatformModel(x+37f,y,18, PLATFORM_HEIGHT,2);
        plat.add(n8);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n4=new NormalPlatformModel(x+15,y,30, PLATFORM_HEIGHT);
        plat.add(n4);
        RedPlatformModel n5=new RedPlatformModel(x+42,y,14, PLATFORM_HEIGHT);
        plat.add(n5);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n9=new NormalPlatformModel(x+2.5f,y,5, PLATFORM_HEIGHT);
        plat.add(n9);
        RedPlatformModel n10=new RedPlatformModel(x+18f,y,16, PLATFORM_HEIGHT,10);
        plat.add(n10);
        NormalPlatformModel n20=new NormalPlatformModel(x+40f,y,10, PLATFORM_HEIGHT);
        plat.add(n20);
        p.setPlatforms(plat);
        templates.add(p);
    }
    /**
     * Creates the type2 template off this difficulty.
     * @param x Used for the 3 worlds creation.
     */
    private void createType2(float x){
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        float y=0;
        NormalPlatformModel n=new NormalPlatformModel(x+13,y,10, PLATFORM_HEIGHT);
        plat.add(n);
        RedPlatformModel n1=new RedPlatformModel(x+32f,y,14, PLATFORM_HEIGHT);
        plat.add(n1);
        NormalPlatformModel n11=new NormalPlatformModel(x+47f,y,6, PLATFORM_HEIGHT);
        plat.add(n11);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        RedPlatformModel n2=new RedPlatformModel(x+15,y,6, PLATFORM_HEIGHT);
        plat.add(n2);
        NormalPlatformModel n3=new NormalPlatformModel(x+42,y,16, PLATFORM_HEIGHT);
        plat.add(n3);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        RedPlatformModel n4=new RedPlatformModel(x+15,y,20, PLATFORM_HEIGHT,5);
        plat.add(n4);
        NormalPlatformModel n5=new NormalPlatformModel(x+42,y,14, PLATFORM_HEIGHT);
        plat.add(n5);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n6=new NormalPlatformModel(x+10,y,4, PLATFORM_HEIGHT);
        plat.add(n6);
        RedPlatformModel n7=new RedPlatformModel(x+24,y,8, PLATFORM_HEIGHT,10);
        plat.add(n7);
        RedPlatformModel n8=new RedPlatformModel(x+39.5f,y,18, PLATFORM_HEIGHT);
        plat.add(n8);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n9=new NormalPlatformModel(x+2.5f,y,5, PLATFORM_HEIGHT);
        plat.add(n9);
        RedPlatformModel n10=new RedPlatformModel(x+20f,y,16, PLATFORM_HEIGHT);
        plat.add(n10);
        NormalPlatformModel n12=new NormalPlatformModel(x+40f,y,16, PLATFORM_HEIGHT);
        plat.add(n12);
        p.setPlatforms(plat);
        templates.add(p);
    }
}
