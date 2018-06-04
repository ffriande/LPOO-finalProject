package com.mygdx.fallball.model.levels;

import com.mygdx.fallball.model.entities.FinalPlatformModel;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.view.View;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.PLATFORM_HEIGHT;

/**
 * BeginCreator.java-Creates all the templates for the start of all levels and final.
 * @see TemplateContainer
 */
public class BeginCreator extends TemplateContainer {
    /**
     * Class constructor.
     * Calls the function to create the templates
     * @param x Used for the 3 worlds creation.
     */
    public BeginCreator(float x){
        super();
        createBeginType(x);
    }

    /**
     * Creates the beginning template and the final plat template.
     * @param x Used for the 3 worlds creation.
     */
    private void createBeginType(float x){
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        float y=0;
        NormalPlatformModel n=new NormalPlatformModel(x+2.5f,y,5, PLATFORM_HEIGHT);
        plat.add(n);
        NormalPlatformModel n1=new NormalPlatformModel(x+29.5f,y,30, PLATFORM_HEIGHT);
        plat.add(n1);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n2=new NormalPlatformModel(x+15,y,26, PLATFORM_HEIGHT);
        plat.add(n2);
        NormalPlatformModel n3=new NormalPlatformModel(x+42,y,8, PLATFORM_HEIGHT);
        plat.add(n3);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n4=new NormalPlatformModel(x+15,y,26, PLATFORM_HEIGHT);
        plat.add(n4);
        NormalPlatformModel n5=new NormalPlatformModel(x+42,y,16, PLATFORM_HEIGHT);
        plat.add(n5);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n6=new NormalPlatformModel(x+10,y,4, PLATFORM_HEIGHT);
        plat.add(n6);
        NormalPlatformModel n7=new NormalPlatformModel(x+20,y,4, PLATFORM_HEIGHT);
        plat.add(n7);
        NormalPlatformModel n8=new NormalPlatformModel(x+39.5f,y,21, PLATFORM_HEIGHT);
        plat.add(n8);
        y-= DISTANCE_BETWEEN_PLATFORMS;
        NormalPlatformModel n9=new NormalPlatformModel(x+2.5f,y,5, PLATFORM_HEIGHT);
        plat.add(n9);
        NormalPlatformModel n10=new NormalPlatformModel(x+29.5f,y,28, PLATFORM_HEIGHT);
        plat.add(n10);
        p.setPlatforms(plat);
        templates.add(p);
        List<PlatformModel> finalPlat=new ArrayList<PlatformModel>();
        PlatformTemplate pf=new PlatformTemplate();
        FinalPlatformModel n11=new FinalPlatformModel(x+View.VIEWPORT_WIDTH/2f,0f,PLATFORM_HEIGHT);
        finalPlat.add(n11);
        pf.setPlatforms(finalPlat);
        templates.add(pf);
    }
}
