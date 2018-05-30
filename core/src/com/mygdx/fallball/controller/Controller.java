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
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.fallball.view.View.PIXEL_TO_METER;

public class Controller implements ContactListener{

    private static Controller instance;



    private /*final*/ World world;



    private /*final*/ BallBody ball;
    private List<PlatformModel> platforms;
    private float accumulator;


    /*private*/Controller(){
        world = new World(new Vector2(0, -10/PIXEL_TO_METER), true);
        ball = new BallBody( world, Model.getInstance().getBall(),  true);

        platforms=new ArrayList<PlatformModel>();
        platforms=Model.getInstance().getPlatforms();
        for(PlatformModel plat: platforms)
            new PlatformBody(world, plat,false);
    }

    public void moveBall(float deltaX){

        ball.setTransform(ball.getX()+deltaX/5f,ball.getY());
    }

    public static Controller getInstance() {
        if (instance == null){
            instance = new Controller();
        System.out.println("New instance of Controller");}
        return instance;

    }

    public void update(float delta) {

        float frameTime = Math.min(delta, 0.25f);
        accumulator += frameTime;
        while (accumulator >= 1 / 60f) {
            world.step(1 / 60f, 6, 2);
            accumulator -= 1 / 60f;
        }

    }
      //TODO: modo infinito

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

        if (bodyA.getUserData() instanceof BallBody && bodyB.getUserData() instanceof RedPlatformModel)
            System.out.println("LOOSE GAME!!!");            //TODO:função perder nivel

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
