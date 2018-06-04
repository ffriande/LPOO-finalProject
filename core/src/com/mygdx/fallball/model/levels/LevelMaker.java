package com.mygdx.fallball.model.levels;

import com.badlogic.gdx.utils.Json;
import com.mygdx.fallball.model.entities.FinalPlatformModel;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.naming.Context;

import static com.mygdx.fallball.view.View.PIXEL_TO_METER;
import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;

public class LevelMaker {
    public final static float DISTANCE_BETWEEN_PLATFORMS = 30;
    public final static float FIRST_PLATFORM_Y = 25;
    public final static float PLATFORM_HEIGHT=3;
    //TODO:fazer mais alguns levels
    //TODO:pensar no algoritmo para o infinite mode
    //TODO:acabar de meter musica
    //TODO:meter highscore

    private final static Random rand=new Random();
    private List<PlatformModel> platforms=new ArrayList<PlatformModel>();

    public LevelMaker(int difficulty){
        level(difficulty);
    }
    public List<PlatformModel> getPlatforms() {
        return platforms;
    }

    private void level(int difficulty){
        TemplateContainer start=new BeginCreator(0);
        start.getTemplates().get(0).setY(FIRST_PLATFORM_Y);
        platforms.addAll(start.getTemplates().get(0).getPlatforms());
        float lastY=start.getTemplates().get(0).getLastY();
        for(int i=0;i<difficulty;i++) {
            for (int y = 0; y < 4; y++) {
                TemplateContainer t1 = new Level1Creator(i + 1);
                int rand_index = rand.nextInt(t1.getTemplates().size());
                PlatformTemplate t=t1.getTemplates().get(rand_index);
                t.setY(lastY - DISTANCE_BETWEEN_PLATFORMS);
                platforms.addAll(t.getPlatforms());
                lastY = t.getLastY();
            }
        }
        start.getTemplates().get(1).setY(lastY-DISTANCE_BETWEEN_PLATFORMS);
        platforms.addAll(start.getTemplates().get(1).getPlatforms());
    }

    //TODO: fazer função auxiliar de randomize para o x das plataformas, tal como para as red plats

    private float randomX(){
        Random r = new Random();
        return (r.nextInt((10+1)+5)/PIXEL_TO_METER);
    }


}
