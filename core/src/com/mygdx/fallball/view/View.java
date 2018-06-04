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
import com.mygdx.fallball.model.entities.BallModel;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;
import com.mygdx.fallball.view.entities.BallView;
import com.mygdx.fallball.view.entities.EntityBaseView;
import com.mygdx.fallball.view.entities.FinalPlatformView;
import com.mygdx.fallball.view.entities.NormalPlatformView;
import com.mygdx.fallball.view.entities.RedPlatformView;
import com.mygdx.fallball.view.menus.Levels;
import com.mygdx.fallball.view.menus.LoseMenu;
import com.mygdx.fallball.view.menus.WinMenu;

import java.util.List;

import static com.mygdx.fallball.controller.Controller.GRAVITY;
import static com.mygdx.fallball.model.levels.LevelMaker.DISTANCE_BETWEEN_PLATFORMS;

public class View extends ScreenAdapter implements GestureDetector.GestureListener {

    public final static float PIXEL_TO_METER = 0.08f;
    public final static float VIEWPORT_WIDTH = 50;
    public static float VOLUME = 0.0f;
    private static final boolean DEBUG_PHYSICS = true;
    public static boolean lose;
    public static boolean win;


    private FallBall game;
    private OrthographicCamera camera;
    private Box2DDebugRenderer debugRenderer;
    private float lowestPoint;
    GestureDetector gestureDetector;
    private float w;
    private float h;
    private float currVel = 1;
    private Matrix4 debugCamera;


    public View(FallBall g) {
        this.game = g;
        win = false;
        lose = false;
        loadAssets();
        createCamera();

        lowestPoint = (h / w) /*/ 2 + DISTANCE_BETWEEN_PLATFORMS / 0.08f*/;
        gestureDetector = new GestureDetector(this);
        Gdx.input.setInputProcessor(gestureDetector);


    }

    private void createCamera() {

        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        System.out.println(w + " " + h);
        camera = new OrthographicCamera(VIEWPORT_WIDTH / PIXEL_TO_METER, VIEWPORT_WIDTH / PIXEL_TO_METER * (h / w));

        camera.position.set(camera.viewportWidth / 2f  /*-VIEWPORT_WIDTH/PIXEL_TO_METER*/, lowestPoint, 0);
        camera.update();

        if (DEBUG_PHYSICS) {
            debugRenderer = new Box2DDebugRenderer();
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PIXEL_TO_METER);
            camera.update();
        }

    }

    private void loadAssets() {

        this.game.getAssetManager().load("redplatform.png", Texture.class);
        this.game.getAssetManager().load("platform.png", Texture.class);
        this.game.getAssetManager().load("ball.png", Texture.class);

        this.game.getAssetManager().load("finalplatform.png", Texture.class);
        this.game.getAssetManager().load("background.png", Texture.class);

        this.game.getAssetManager().finishLoading();
    }


    @Override
    public void render(float delta) {
        if (win) {
            if (Model.getInstance().getLevel() == Levels.getInstance().getNrUnlocked() &&
                    Model.getInstance().getLevel() < Levels.getInstance().getNrLevels()) {
                Levels.getInstance().increaseNrUnlocked();
                Levels.getInstance().write(Levels.getInstance().getJson());
            }
                game.setScreen(new WinMenu(game));
        }
        if (lose)
            game.setScreen(new LoseMenu(game));

        velocityChecker();

        Controller.getInstance().update(delta);

        if (Controller.getInstance().getBall().getY() / PIXEL_TO_METER < lowestPoint) {
            camera.translate(0, Controller.getInstance().getBall().getY() / PIXEL_TO_METER - lowestPoint);
            camera.update();
            lowestPoint = Controller.getInstance().getBall().getY() / PIXEL_TO_METER;
        }


        camera.update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();


        drawBackground();
        drawPlats();
        drawBall();
        game.getBatch().end();


        if (DEBUG_PHYSICS) {
            debugCamera = camera.combined.cpy();
            debugCamera.scl(1 / PIXEL_TO_METER);
            debugRenderer.render(Controller.getInstance().getWorld(), debugCamera);
            // camera.update();
        }
    }

    @Override
    public void dispose() {
        debugRenderer.dispose();
    }

    private void drawPlats() {
        List<PlatformModel> p = Model.getInstance().getPlatforms();
        for (PlatformModel it : p) {
            if (it.getX() - it.getWidth() / 2f >= 0 && it.getX() + it.getWidth() / 2f <= VIEWPORT_WIDTH) {
                EntityBaseView b;
                if (it instanceof NormalPlatformModel) {
                    b = new NormalPlatformView(game);
                    b.update(it);
                } else if (it instanceof RedPlatformModel) {
                    b = new RedPlatformView(game);
                    b.update(it);
                } else {
                    b = new FinalPlatformView(game);
                    b.update(it);
                }
                b.draw(game.getBatch(), it);
            }

        }
    }

    private void drawBall() {
        BallModel mod = Model.getInstance().getBall();
        float limitLeft = mod.getRadius(), limitRight = VIEWPORT_WIDTH - mod.getRadius();

        EntityBaseView b = new BallView(game);
        b.update(mod);
        b.draw(game.getBatch());
        if (mod.getX() < limitLeft) {
            BallModel mod2 = Model.getInstance().getBall();
            mod2.setPos(VIEWPORT_WIDTH + mod2.getX(), mod2.getY());
            EntityBaseView b2 = new BallView(game);
            b2.update(mod2);
            b2.draw(game.getBatch());
        } else if (mod.getX() > limitRight) {
            BallModel mod2 = Model.getInstance().getBall();
            mod2.setPos(mod2.getX() - VIEWPORT_WIDTH, mod2.getY());
            EntityBaseView b2 = new BallView(game);
            b2.update(mod2);
            b2.draw(game.getBatch());
        }

    }

    private void drawBackground() {
        Texture background = game.getAssetManager().get("background.png", Texture.class);
        background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        game.getBatch().draw(background, camera.position.x - camera.viewportWidth / 2f, camera.position.y - camera.viewportHeight / 2f, 0, 0, (int) camera.viewportWidth, (int) camera.viewportHeight + 200);
    }

    public static void muteFX() {
        VOLUME = 0.0f;
    }

    public static void normalizeFX() {
        VOLUME = 1.0f;
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
        Controller.getInstance().getBall().setVelX_to_zero();
        Controller.getInstance().moveBall(deltaX);
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

    private void velocityChecker() {
        double intendedVel = Math.sqrt(2 * Math.abs(GRAVITY) * (DISTANCE_BETWEEN_PLATFORMS * 0.65f)); //formula da conservaçao da Emecanica.
        if (Controller.getInstance().getBall().getVelocity().y > 0 && currVel < 0  /*&& Controller.getInstance().getBall().getVelocity().y > intendedVel*/) {
            Controller.getInstance().getBall().setVelocity(intendedVel);
        }
        currVel = Controller.getInstance().getBall().getVelocity().y;
    }
}
