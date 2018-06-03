package com.mygdx.fallball.model.levels;


import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.PLATFORM_HEIGHT;

public class TemplateContainer{
    int difficulty;
    List<PlatformTemplate> templates=new ArrayList<PlatformTemplate>();

    public TemplateContainer(int difficulty){
        this.difficulty=difficulty;
    }

    public List<PlatformTemplate> getTemplates(){
        return templates;
    }

    public int getDifficulty(){
        return difficulty;
    }



}
