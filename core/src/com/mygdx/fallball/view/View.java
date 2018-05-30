package com.mygdx.fallball.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.input.GestureDetector;
//import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.controller.Controller;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.model.entities.EntityBaseModel;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;
import com.mygdx.fallball.view.entities.BallView;
import com.mygdx.fallball.view.entities.EntityBaseView;
import com.mygdx.fallball.view.entities.PlatformView;

import java.util.List;

public class View extends ScreenAdapter implements GestureDetector.GestureListener{

    public final static float PIXEL_TO_METER = 0.08f;
    public final static float VIEWPORT_WIDTH = 60;
    private static final boolean DEBUG_PHYSICS = true;



    private FallBall game;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
    private float lowestPoint;
    GestureDetector gestureDetector;
    private float w;
    private float h;
    private float currVel=-1;

    private Matrix4 debugCamera;


    public View(FallBall g) {
        this.game = g;
       loadAssets();
       createCamera();

        lowestPoint= (h / w) /2 + 200;
        gestureDetector = new GestureDetector(this);
        Gdx.input.setInputProcessor(gestureDetector);


    }

    private void createCamera() {

        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(VIEWPORT_WIDTH/PIXEL_TO_METER, VIEWPORT_WIDTH/PIXEL_TO_METER * (h / w));

        camera.position.set(camera.viewportWidth / 2f, lowestPoint, 0);
        camera.update();

        if (DEBUG_PHYSICS) {
            debugRenderer = new Box2DDebugRenderer();
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PIXEL_TO_METER);
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
       hitEdge();
        Controller.getInstance().update(delta);
        Model.getInstance().update(Controller.getInstance().getBall().getX(),Controller.getInstance().getBall().getY());

        if(Controller.getInstance().getBall().getY()/PIXEL_TO_METER<lowestPoint && Controller.getInstance().getBall().getY()/PIXEL_TO_METER<(h/w)/2 +200){
            camera.translate(0,Controller.getInstance().getBall().getY()/PIXEL_TO_METER-lowestPoint);
            camera.update();
            lowestPoint=Controller.getInstance().getBall().getY()/PIXEL_TO_METER;
            System.out.println("YOOO  " +lowestPoint+ "  Camerapos: " + camera.position.y);
        }


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.getBatch().begin();


//        System.out.println("CAmera pos after: "+camera.position.x +" " +camera.position.y );
       drawBackground();

        drawPlats();
        drawBall();
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        //drawBackground();
//        System.out.println(Model.getInstance().getBall().getX()+" - x;    "+Model.getInstance().getBall().getY()+" - y");
//
//        System.out.println("Ball body"+Controller.getInstance().getBall().getX()+" - x;    "+Controller.getInstance().getBall().getY()+" - y");





        game.getBatch().end();
        if (DEBUG_PHYSICS) {
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PIXEL_TO_METER);
            debugRenderer.render(Controller.getInstance().getWorld(), debugCamera);
           // camera.update();
        }
    }

    private void handleInputs(float delta) {
    }


    private void drawPlats(){
        List<PlatformModel> p= Model.getInstance().getPlatforms();
        for(PlatformModel it: p){
            EntityBaseView b= new PlatformView(game);  //TODO: aplicar factory
            b.update(it);
            if(it instanceof NormalPlatformModel)
                b.draw(game.getBatch(),it);
            else if(it instanceof RedPlatformModel)
                b.draw(game.getBatch(),it);//TODO: mudar isto e fazer outra imagem de plataforma red

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
        game.getBatch().draw(background, camera.position.x - camera.viewportWidth/2 , camera.position.y-camera.viewportHeight/2, 0, 0, (int)camera.viewportWidth, (int)camera.viewportHeight+2);
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

    private void hitEdge(){

        if(Controller.getInstance().getBall().getVelocity().y>0 && currVel<0  && Controller.getInstance().getBall().getVelocity().y< 10/PIXEL_TO_METER){
            Controller.getInstance().getBall().applyImpulse(1000000);
            System.out.println("\n\n\n\n ZAAAS\n\n");
        }
        currVel =Controller.getInstance().getBall().getVelocity().y;
        System.out.println("\n"+currVel+"\n");

    }
}

//TODO:Meter a bola a desaparecer de um lado e a aparecer no outro
//TODO: Plataformas vermelhas a mexer
//TODO: Condição de Win, aplicar maquina de estados
//TODO: Menu