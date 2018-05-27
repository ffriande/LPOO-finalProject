package com.mygdx.fallball.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.controller.Controller;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.model.entities.EntityBaseModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.view.entities.BallView;
import com.mygdx.fallball.view.entities.EntityBaseView;
import com.mygdx.fallball.view.entities.PlatformView;

import java.util.List;

public class View extends ScreenAdapter implements GestureDetector.GestureListener{
    private FallBall game;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
    private float lowestPoint;
    GestureDetector gestureDetector;
    boolean debug;
    private float w;
    private float h;

    private Matrix4 debugCamera;


    public View(FallBall g) {
        debug=false;
        this.game = g;
       loadAssets();
        createCamera();

        lowestPoint=h/w-2/0.02f;
        gestureDetector = new GestureDetector(this);
        Gdx.input.setInputProcessor(gestureDetector);


    }

    private void createCamera() {

        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        //System.out.println("ViewPort before: "+camera.viewportWidth +" " +camera.viewportHeight);
        camera = new OrthographicCamera(40/0.02f, 40/0.02f * (h / w));

        camera.position.set(camera.viewportWidth / 2f, lowestPoint, 0);
        camera.update();
        System.out.println("ViewPort after: "+camera.viewportWidth +" " +camera.viewportHeight);
        System.out.println("CAmera pos after: "+camera.position.x +" " +camera.position.y );

        if (debug) {
            debugRenderer = new Box2DDebugRenderer();
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / 0.02f);
            camera.update();
        }


    }

    private void loadAssets() {

        this.game.getAssetManager().load( "platform.jpg" , Texture.class);
        this.game.getAssetManager().load( "ball.png" , Texture.class);

        this.game.getAssetManager().load( "background.png" , Texture.class);

        this.game.getAssetManager().finishLoading();
    }


    @Override
    public void render(float delta) {
////        GameController.getInstance().removeFlagged();
////        GameController.getInstance().createNewAsteroids();
//
//        handleInputs(delta);
//
////        GameController.getInstance().update(delta);
//
//        camera.position.set(GameModel.getInstance().getShip().getX() / PIXEL_TO_METER, GameModel.getInstance().getShip().getY() / PIXEL_TO_METER, 0);
//        camera.update();
//        game.getBatch().setProjectionMatrix(camera.combined);
//
//        Gdx.gl.glClearColor( 103/255f, 69/255f, 117/255f, 1 );
//        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
//
//        game.getBatch().begin();
//        drawBackground();
//        drawBall();
//        game.getBatch().end();
//
////        if (DEBUG_PHYSICS) {
////            debugCamera = camera.combined.cpy();
////            debugCamera.scl(1 / PIXEL_TO_METER);
////            debugRenderer.render(GameController.getInstance().getWorld(), debugCamera);
//        }

        Controller.getInstance().update(delta);
        Model.getInstance().update(Controller.getInstance().getBall().getX(),Controller.getInstance().getBall().getY());


        if(Controller.getInstance().getBall().getY()<lowestPoint && Controller.getInstance().getBall().getY()<(h / w)){
            camera.translate(0,Controller.getInstance().getBall().getY()-lowestPoint);
            camera.update();
            lowestPoint=Controller.getInstance().getBall().getY();
            System.out.println("YOOO  " +lowestPoint+ "  Camerapos: " + camera.position.y);

        }


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.getBatch().begin();


       drawBackground();
       drawBall(); //TODO: por isto  a funcionar. funciona sem debug
        drawPlats();
        //drawBackground();
        System.out.println(Model.getInstance().getBall().getX()+" - x;    "+Model.getInstance().getBall().getY()+" - y");

        System.out.println(Controller.getInstance().getBall().getX()+" - x;    "+Controller.getInstance().getBall().getY()+" - y");





        game.getBatch().end();
        if (debug) {
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / 0.02f);
            debugRenderer.render(Controller.getInstance().getWorld(), debugCamera);
            camera.update();
        }
    }

    private void handleInputs(float delta) {
    }


    private void drawPlats(){
        List<PlatformModel> p= Model.getInstance().getPlatforms();
        for(PlatformModel it: p){
            EntityBaseView b= new PlatformView(game);
            b.update(it);
            b.draw(game.getBatch(),it);
        }
    }
    private void drawBall(){
        EntityBaseModel mod=Model.getInstance().getBall();
        EntityBaseView b= new BallView(game);
        b.update(mod);
        b.draw(game.getBatch());

    }

    private void drawBackground() {
        Texture background = game.getAssetManager().get("background.png", Texture.class);
        background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        game.getBatch().draw(background, 0, 0, 0, 0, (int)w, (int)h);
    }


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        Controller.getInstance().moveBall(deltaX);
        System.out.println("Pan "+ deltaX);
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}