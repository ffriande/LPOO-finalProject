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
import static com.mygdx.fallball.view.View.PIXEL_TO_METER;
import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;

public class Controller implements ContactListener {
    public final static float GRAVITY = -18;
    public final static float SENSIBILITY = 0.025f;

    private static Controller instance;


    private /*final*/ World world;


    private /*final*/ BallBody ball;
    private List<PlatformModel> platforms;
    private float accumulator;
    private List<PlatformBody> redPlats;
    private PlatformBody finalPlat;


    /*private*/Controller() {
        world = new World( new Vector2( 0, GRAVITY ), true );
        ball = new BallBody( world, Model.getInstance().getBall());
        world.setContactListener( this );
        platforms = new ArrayList<PlatformModel>();
        platforms = Model.getInstance().getPlatforms();
        redPlats = new ArrayList<PlatformBody>();
        for (PlatformModel plat : platforms) {
            if (plat instanceof NormalPlatformModel)
                new PlatformBody( world, plat, false );
            else if (plat instanceof RedPlatformModel) {
                PlatformBody b = new PlatformBody( world, plat, ((RedPlatformModel) plat).getMoving() );
                redPlats.add( b );
            } else {
                finalPlat = new PlatformBody( world, plat, false );
            }
        }
    }

    public void moveBall(float deltaX) {

        ball.setTransform( ball.getX() + deltaX * SENSIBILITY, ball.getY() );
    }


    public static Controller getInstance() {
        if (instance == null)
            instance = new Controller();
        return instance;

    }
    public static void newInstance() {
        instance = new Controller();
    }

    public void update(float delta) {
        float frameTime = Math.min( delta, 0.25f );
        accumulator += frameTime;
        while (accumulator >= 1 / 60f) {
            world.step( 1 / 60f, 6, 2 );
            accumulator -= 1 / 60f;
        }
        //Desaparece de um lado, aparece no outro
        if (ball.getX() < -Model.getInstance().getBall().getRadius())
            ball.setTransform( VIEWPORT_WIDTH - Model.getInstance().getBall().getRadius(), ball.getY() );
        else if (ball.getX() > VIEWPORT_WIDTH + Model.getInstance().getBall().getRadius())
            ball.setTransform( Model.getInstance().getBall().getRadius(), ball.getY() );

        Model.getInstance().update( Controller.getInstance().getBall().getX(), Controller.getInstance().getBall().getY() ); //actualiza posiçao da bola
        int i = 0;
        for (PlatformModel plat : Model.getInstance().getPlatforms()) {
            if (plat instanceof RedPlatformModel && ((RedPlatformModel) plat).getMoving()) {
                int j = i;
                for (PlatformBody it : redPlats) {
                    if (it.isMoving()) {
                        it.moveRedPlat();
                        if (j == 0) {
                            plat.setPos( it.getX(), it.getY() );
                            i++;
                            break;
                        } else j--;
                    }
                }
            }
        }

    }

    public World getWorld() {
        return world;
    }

    public BallBody getBall() {
        return ball;
    }


    @Override
    public void beginContact(Contact contact) {
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();

        float destroyerVelocity = (float)Math.sqrt(2*Math.abs(GRAVITY)*(3*PLATFORM_HEIGHT+3* DISTANCE_BETWEEN_PLATFORMS));
        if(bodyB.getUserData()  == ball.getUserData())
        if(ball.getVelocity().y<=(-destroyerVelocity)){
            bodyA.setActive(false);
            Model.getInstance().destroyPlatform(ball.getX(),ball.getY(),Model.getInstance().getBall().getRadius());
        }

        if (finalPlat != null)
            if (bodyB.getUserData() == ball.getUserData() && bodyA.getUserData() == finalPlat.getUserData()) {
                View.win = true;
                //System.out.println( "WIN GAME!!!\n\n\n\n\n\n" );                 //TODO:função ganhar jogo
            }
        for (PlatformBody it : redPlats)
            if (bodyB.getUserData() == ball.getUserData() && bodyA.getUserData() == it.getUserData())
                View.lose=true;
                //System.out.println( "LOOSE GAME!!!\n\n\n\n\n\n" );                 //TODO:função perder nivel

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
