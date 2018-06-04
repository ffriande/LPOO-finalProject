package com.mygdx.fallball.model.levels;



import java.util.ArrayList;
import java.util.List;
/**
 * TemplateContainer.java-Contains all the templates of a certain difficulty.
 */
public class TemplateContainer{

    /**
     * List that contains all the templates of a certain difficulty.
     */
    List<PlatformTemplate> templates=new ArrayList<PlatformTemplate>();


    /**
     * Returns all the templates.
     * @return this.templates.
     */
    public List<PlatformTemplate> getTemplates(){
        return templates;
    }



}
