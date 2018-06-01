package com.mygdx.fallball.controller.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.fallball.model.entities.BallModel;

import static com.mygdx.fallball.model.entities.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;

public class BallBody extends EntityBody {
    public BallBody(World world, BallModel model) {
            super(world, model, false);
        float   radius = model.getRadius(),
                density = 1f,
                friction = 0f,
                restitution = 1f;


        createBallFixture(body, radius, density, friction, restitution);
       body.setType(BodyDef.BodyType.DynamicBody);

    }
    public void applyImpulse(float impulseY){
        body.applyLinearImpulse(0,impulseY,this.getX(),this.getY(), true);
    }



    final void createBallFixture(Body body, float radius, float density, float friction, float restitution/*,short category, short mask */ ) {


        CircleShape circle = new CircleShape();
        circle.setRadius(radius);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = density;
        fixtureDef.friction = friction;
        fixtureDef.restitution = restitution; // Make it bounce a little bit



     /*   fixtureDef.filter.categoryBits = category; //filter is for not to happen collision acho eu
        fixtureDef.filter.maskBits = mask;
        */


        body.createFixture(fixtureDef);

        circle.dispose();
    }


    public void setVelX_to_zero(){
        body.setLinearVelocity(0,body.getLinearVelocity().y );
    }

    public void setVelocity(double y){
        body.setLinearVelocity( 0, (float)y );
    }
    public Vector2 getVelocity(){
        return body.getLinearVelocity();
    }
}
