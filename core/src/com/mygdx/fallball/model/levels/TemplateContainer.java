package com.mygdx.fallball.model.levels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class TemplateContainer implements java.io.Serializable{
    int difficulty;
    List<PlatformTemplate> templates=new ArrayList<PlatformTemplate>();

    public TemplateContainer(){
    }

    public List<PlatformTemplate> getTemplates(){
        return templates;
    }

    public void setAll(int difficulty,List<PlatformTemplate> templates){
        this.difficulty=difficulty;
        this.templates=templates;
    }

    public int getDifficulty(){
        return difficulty;
    }
}
