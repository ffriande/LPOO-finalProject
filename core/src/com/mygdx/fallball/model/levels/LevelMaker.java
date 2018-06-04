package com.mygdx.fallball.model.levels;

import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelMaker {
    /**
     * Used to calculate distance between platforms.
     */
    public final static float DISTANCE_BETWEEN_PLATFORMS = 30;
    /**
     * Position in y of the first line of platforms.
     */
    public final static float FIRST_PLATFORM_Y = 25;
    /**
     * Height of standard platforms.
     */
    public final static float PLATFORM_HEIGHT = 3;

    /**
     * Used to get random numbers.
     */
    private final static Random rand = new Random();
    /**
     * List of all platforms of current level.
     */
    private List<PlatformModel> platforms = new ArrayList<PlatformModel>();
    /**
     * Used for left unseen world for startType.
     */
    private TemplateContainer start0 = new BeginCreator(-View.VIEWPORT_WIDTH);
    /**
     * Used for center world for startType.
     */
    private TemplateContainer start1 = new BeginCreator(0);
    /**
     * Used for right unseen world for startType.
     */
    private TemplateContainer start2 = new BeginCreator(View.VIEWPORT_WIDTH);

    /**
     * Class constructor.
     * Calls the function to create the level that is supposed.
     * @param difficulty Type of integer.
     */
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

    /**
     * Gets all the platforms of the level created.
     * @return this.platforms.
     */
    public List<PlatformModel> getPlatforms() {
        return platforms;
    }

    /**
     * Adds the starttype to the list of platforms.
     */
    private void addStart(){
        start0.getTemplates().get(0).setY(FIRST_PLATFORM_Y);
        start1.getTemplates().get(0).setY(FIRST_PLATFORM_Y);
        start2.getTemplates().get(0).setY(FIRST_PLATFORM_Y);
        platforms.addAll(start0.getTemplates().get(0).getPlatforms());
        platforms.addAll(start1.getTemplates().get(0).getPlatforms());
        platforms.addAll(start2.getTemplates().get(0).getPlatforms());
    }

    /**
     * Adds the finaltype to the list of platforms.
     * @param y Y to be setted in the template.
     */
    private void addFinal(float y){
        start1.getTemplates().get(1).setY(y - DISTANCE_BETWEEN_PLATFORMS);
        platforms.addAll(start1.getTemplates().get(1).getPlatforms());
    }

    /**
     * Creates level1.
     */
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

    /**
     * Creates level2.
     * Uses some templates of level1.
     */
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

    /**
     * Creates level3.
     * Uses some templates of level 1 and 2.
     */
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

    /**
     * Creates level4.
     * Uses some templates of level 3 and 4.
     */
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

    /**
     * Gets a random template of the list of templates.
     * @param t0 Template container with X setted to left unseen world.
     * @param t1 Template container with X setted to center world.
     * @param t2 Template container with X setted to right unseen world.
     * @param y Y coordinate to be setted in the template containers.
     * @return Template in center that will be added to platforms.
     */
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
