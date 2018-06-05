package com.mygdx.fallball.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.controller.entities.BallBody;
import com.mygdx.fallball.controller.entities.PlatformBody;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;
import com.mygdx.fallball.view.View;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;
import static com.mygdx.fallball.model.levels.LevelMaker.PLATFORM_HEIGHT;
import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;
/**
 * Controls the physics of the game.
 *
 * @see ContactListener
 */
public class Controller implements ContactListener {
    /**
     *Gravity force of the simulation
     */
    public final static float GRAVITY = -30;

    /**
     * Sensibility of the user's movement of the ball
     */
    public final static float SENSIBILITY = 0.025f;
    /**
     * singleton instance of Controller itself
     */
    private static Controller instance;
    /**
     * Physics simulator of the controller
      */
    private /*final*/ World world;
    /**
     * Bouncing ball's body
     */
    private BallBody ball;
    /**
     * Accumulator used to calculate the simulation step.
     */
    private float accumulator;
    /**
     * Red platforms' bodies
     */
    private List<PlatformBody> redPlats;
    /**
     * The final platform of a level
     */
    private PlatformBody finalPlat;

    /**
     * Creates a new Controller, with all the game elements' bodies.
     */
    private Controller() {
        List<PlatformModel> platforms;
        world = new World(new Vector2(0, GRAVITY), true);
        ball = new BallBody(world, Model.getInstance().getBall());
        world.setContactListener(this);
        platforms = Model.getInstance().getPlatforms();
        redPlats = new ArrayList<PlatformBody>();
        for (PlatformModel plat : platforms) {
            if (plat instanceof NormalPlatformModel)
                new PlatformBody(world, plat, false);
            else if (plat instanceof RedPlatformModel) {
                PlatformBody b = new PlatformBody(world, plat, ((RedPlatformModel) plat).getMoving());
                redPlats.add(b);
            } else {
                finalPlat = new PlatformBody(world, plat, false);
            }
        }
    }

    /**
     * Moves ball is x axis
     * @param deltaX ammount of moving in ball
     */
    public void moveBall(float deltaX) {

        ball.setTransform(ball.getX() + deltaX * SENSIBILITY, ball.getY());
    }

    /**
     * Returns a singleton instance of game controller
     * @return the singleton instance
     */
    public static Controller getInstance() {
        if (instance == null)
            instance = new Controller();
        return instance;

    }

    /**
     * Singleton instance gets updated
     */
    public static void newInstance() {
        instance = new Controller();
    }

    /**
     * Calculates the next physics step of duration delta.
     * @param delta The size of this physics step in seconds.
     */
    public void update(float delta) {
        float frameTime = Math.min(delta, 0.25f);
        accumulator += frameTime;
        while (accumulator >= 1 / 60f) {
            world.step(1 / 60f, 6, 2);
            accumulator -= 1 / 60f;
        }
        //Desaparece de um lado, aparece no outro
        if (ball.getX() < -Model.getInstance().getBall().getRadius())
            ball.setTransform(VIEWPORT_WIDTH - Model.getInstance().getBall().getRadius(), ball.getY());
        else if (ball.getX() > VIEWPORT_WIDTH + Model.getInstance().getBall().getRadius())
            ball.setTransform(Model.getInstance().getBall().getRadius(), ball.getY());

        Model.getInstance().update(Controller.getInstance().getBall().getX(), Controller.getInstance().getBall().getY()); //actualiza posiçao da bola
        int i = 0;
        for (PlatformModel plat : Model.getInstance().getPlatforms()) {
            if (plat instanceof RedPlatformModel && ((RedPlatformModel) plat).getMoving()) {
                int j = i;
                for (PlatformBody it : redPlats) {
                    if (it.isMoving()) {
                        it.moveRedPlat();
                        if (j == 0) {
                            plat.setPos(it.getX(), it.getY());
                            i++;
                            break;
                        } else j--;
                    }
                }
            }
        }

    }
    /**
     * Returns the world controlled by this controller.
     *
     * @return The world controlled by this controller.
     */
    public World getWorld() {
        return world;
    }

    /**
     * Returns the body of the ball in Controller's world.
     * @return Ball  body
     */
    public BallBody getBall() {
        return ball;
    }

    /**
     * Handles a contact between two objects
     * @param contact the detected contact
     */
    @Override
    public void beginContact(Contact contact) {
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();

        float destroyerVelocity = (float) Math.sqrt(2 * Math.abs(GRAVITY) * (3 * PLATFORM_HEIGHT + 3 * DISTANCE_BETWEEN_PLATFORMS));
        if (finalPlat != null)
            if (bodyB.getUserData() == ball.getUserData() && bodyA.getUserData() == finalPlat.getUserData()) {
                System.out.println("WIN");
                View.win = true;
                return;
            }
        if (bodyB.getUserData() == ball.getUserData())
            if (ball.getVelocity().y <= (-destroyerVelocity)) {
                bodyA.setActive(false);
                world.destroyBody(bodyA);
                Model.getInstance().destroyPlatform(ball.getX(), ball.getY(), Model.getInstance().getBall().getRadius());
                return;
            }
        for (PlatformBody it : redPlats) {
            if (bodyB.getUserData() == ball.getUserData() && bodyA.getUserData() == it.getUserData()) {
                View.lose = true;
                return;
            }
        }
        View.bounce.play(View.VOLUME);


    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }


}
