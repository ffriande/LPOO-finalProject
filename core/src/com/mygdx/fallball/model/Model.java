package com.mygdx.fallball.model;


import com.mygdx.fallball.model.entities.BallModel;
import com.mygdx.fallball.model.levels.LevelMaker;
import com.mygdx.fallball.model.entities.PlatformModel;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.FIRST_PLATFORM_Y;
import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;

/**
 * Model.java-Model that represents the game.
 */
public class Model {
    /**
     * The singleton instance of the game model
     */
    private static Model instance;
    /**
     * Current playing level.
     */
    private int level;

    /**
     * Model of the ball.
     */
    private BallModel ball;

    /**
     * List with all the platform models.
     */
    private List<PlatformModel> platforms = new ArrayList<PlatformModel>();

    /**
     * Returns a singleton instance of the game model
     *
     * @return the singleton instance
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
            System.out.println("New instance of Model");
        }
        return instance;
    }

    /**
     * Class constructor.
     * Calls the LevelMaker to create a certain level.
     * Calls the constructor of the ball model.
     */
    private Model() {
        ball = new BallModel(VIEWPORT_WIDTH / 2f, FIRST_PLATFORM_Y + DISTANCE_BETWEEN_PLATFORMS, 1.5f);
        this.level=1;
        platforms = new LevelMaker(1).getPlatforms();
    }

    /**
     * Restarts the ball.
     * Restarts the platforms to a new pretended level.
     * @param i The level that is pretended.
     */
    public void setLevel(int i) {
        ball = new BallModel(VIEWPORT_WIDTH / 2f, FIRST_PLATFORM_Y + DISTANCE_BETWEEN_PLATFORMS, 1.5f);
        platforms.clear();
        platforms = new LevelMaker(i).getPlatforms();
        this.level=i;
    }

    /**
     * Gets the current level.
     * @return this.level.
     */
    public int getLevel(){
        return this.level;
    }

    /**
     * Gets the model of the ball.
     * @return this.ball.
     */
    public BallModel getBall() {
        return ball;
    }

    /**
     * Gets all the platform models.
     * @return Type of list, list with all platform models.
     */
    public List<PlatformModel> getPlatforms() {
        return platforms;
    }

    /**
     * Updates the ball position.
     * @param x Coordinate in x.
     * @param y Coordinate in y.
     */
    public void update(float x, float y) {
        ball.setPos(x, y);
    }

    /**
     * Destroys a certain platform model.
     * Uses some magin of error to get the right platform.
     * @param x Coordinate in x.
     * @param y Coordinate in y.
     * @param radius Radius of the ball.
     */
    public void destroyPlatform(float x, float y, float radius) {
        float renderErrorMargin = 0.3f;
        for (PlatformModel it : platforms) {
            if ((it.getY() + it.getHeight() / 2 - renderErrorMargin <= y - radius && it.getY() + it.getHeight() / 2 + renderErrorMargin >= y - radius)
                    && (x + radius + renderErrorMargin >= it.getX() - it.getWidth() / 2f || x + radius -renderErrorMargin >= it.getX() - it.getWidth() / 2f)&&
                    (x - radius -renderErrorMargin <= it.getX() + it.getWidth() / 2f || x - radius + renderErrorMargin<= it.getX() + it.getWidth() / 2f)) {
                platforms.remove(it);
                System.out.println("Destroyed moving red");
                break;
            }
        }
    }

}
