package com.mygdx.fallball.model.levels;

import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelMaker {
    public final static float DISTANCE_BETWEEN_PLATFORMS = 30;
    public final static float FIRST_PLATFORM_Y = 25;
    public final static float PLATFORM_HEIGHT = 3;
    //TODO:fazer mais alguns levels
    //TODO:pensar no algoritmo para o infinite mode
    //TODO:acabar de meter musica
    //TODO:meter highscore

    private final static Random rand = new Random();
    private List<PlatformModel> platforms = new ArrayList<PlatformModel>();
    private TemplateContainer start0 = new BeginCreator(-View.VIEWPORT_WIDTH);
    private TemplateContainer start1 = new BeginCreator(0);
    private TemplateContainer start2 = new BeginCreator(View.VIEWPORT_WIDTH);

    public LevelMaker(int difficulty) {
        switch (difficulty) {
            case 1:
                level1();
                break;
            case 2:
                level2();
                break;
            case 3:
                level3();
                break;
            case 4:
                level4();
                break;
        }
    }

    public List<PlatformModel> getPlatforms() {
        return platforms;
    }


    private void addStart(){
        start0.getTemplates().get(0).setY(FIRST_PLATFORM_Y);
        start1.getTemplates().get(0).setY(FIRST_PLATFORM_Y);
        start2.getTemplates().get(0).setY(FIRST_PLATFORM_Y);
        platforms.addAll(start0.getTemplates().get(0).getPlatforms());
        platforms.addAll(start1.getTemplates().get(0).getPlatforms());
        platforms.addAll(start2.getTemplates().get(0).getPlatforms());
    }

    private void addFinal(float y){
        start1.getTemplates().get(1).setY(y - DISTANCE_BETWEEN_PLATFORMS);
        platforms.addAll(start1.getTemplates().get(1).getPlatforms());
    }

    private void level1() {
        addStart();
        float lastY = start1.getTemplates().get(0).getLastY();
        for (int y = 0; y < 4; y++) {
            TemplateContainer t0 = new Level1Creator(-View.VIEWPORT_WIDTH);
            TemplateContainer t1 = new Level1Creator(0f);
            TemplateContainer t2 = new Level1Creator(View.VIEWPORT_WIDTH);
            PlatformTemplate t=RandTemplate(t0,t1,t2,lastY);
            lastY = t.getLastY();
        }
        addFinal(lastY);
    }

    private void level2() {
        addStart();
        float lastY = start1.getTemplates().get(0).getLastY();
        for (int y = 0; y < 2; y++) {
            TemplateContainer t0 = new Level1Creator(-View.VIEWPORT_WIDTH);
            TemplateContainer t1 = new Level1Creator(0f);
            TemplateContainer t2 = new Level1Creator(View.VIEWPORT_WIDTH);
            PlatformTemplate t=RandTemplate(t0,t1,t2,lastY);
            lastY = t.getLastY();
        }
        for (int y = 0; y < 5; y++) {
            TemplateContainer t0 = new Level2Creator(-View.VIEWPORT_WIDTH);
            TemplateContainer t1 = new Level2Creator(0f);
            TemplateContainer t2 = new Level2Creator(View.VIEWPORT_WIDTH);
            PlatformTemplate t=RandTemplate(t0,t1,t2,lastY);
            lastY = t.getLastY();
        }
        addFinal(lastY);
    }

    private void level3(){
        addStart();
        float lastY = start1.getTemplates().get(0).getLastY();
        for (int y = 0; y < 1; y++) {
            TemplateContainer t0 = new Level1Creator(-View.VIEWPORT_WIDTH);
            TemplateContainer t1 = new Level1Creator(0f);
            TemplateContainer t2 = new Level1Creator(View.VIEWPORT_WIDTH);
            PlatformTemplate t=RandTemplate(t0,t1,t2,lastY);
            lastY = t.getLastY();
        }
        for (int y = 0; y < 3; y++) {
            TemplateContainer t0 = new Level2Creator(-View.VIEWPORT_WIDTH);
            TemplateContainer t1 = new Level2Creator(0f);
            TemplateContainer t2 = new Level2Creator(View.VIEWPORT_WIDTH);
            PlatformTemplate t=RandTemplate(t0,t1,t2,lastY);
            lastY = t.getLastY();
        }
        for (int y = 0; y < 4; y++) {
            TemplateContainer t0 = new Level3Creator(-View.VIEWPORT_WIDTH);
            TemplateContainer t1 = new Level3Creator(0f);
            TemplateContainer t2 = new Level3Creator(View.VIEWPORT_WIDTH);
            PlatformTemplate t=RandTemplate(t0,t1,t2,lastY);
            lastY = t.getLastY();
        }
        addFinal(lastY);
    }

    private void level4(){
        addStart();
        float lastY = start1.getTemplates().get(0).getLastY();
        for (int y = 0; y < 3; y++) {
            TemplateContainer t0 = new Level3Creator(-View.VIEWPORT_WIDTH);
            TemplateContainer t1 = new Level3Creator(0f);
            TemplateContainer t2 = new Level3Creator(View.VIEWPORT_WIDTH);
            PlatformTemplate t=RandTemplate(t0,t1,t2,lastY);
            lastY = t.getLastY();
        }
        for (int y = 0; y < 4; y++) {
            TemplateContainer t0 = new Level4Creator(-View.VIEWPORT_WIDTH);
            TemplateContainer t1 = new Level4Creator(0f);
            TemplateContainer t2 = new Level4Creator(View.VIEWPORT_WIDTH);
            PlatformTemplate t=RandTemplate(t0,t1,t2,lastY);
            lastY = t.getLastY();
        }
        addFinal(lastY);
    }

    private PlatformTemplate RandTemplate(TemplateContainer t0,TemplateContainer t1,TemplateContainer t2,float y){
        int rand_index = rand.nextInt(t1.getTemplates().size());
        PlatformTemplate t0p = t0.getTemplates().get(rand_index);
        PlatformTemplate t1p = t1.getTemplates().get(rand_index);
        PlatformTemplate t2p = t2.getTemplates().get(rand_index);
        t0p.setY(y-DISTANCE_BETWEEN_PLATFORMS);
        t1p.setY(y - DISTANCE_BETWEEN_PLATFORMS);
        t2p.setY(y - DISTANCE_BETWEEN_PLATFORMS);
        platforms.addAll(t0p.getPlatforms());
        platforms.addAll(t1p.getPlatforms());
        platforms.addAll(t2p.getPlatforms());
        return t1p;
    }



}
