package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.controller.Controller;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.view.View;


public class LoseMenu extends ScreenAdapter {


    private FallBall game;
    private Stage stage;
    private Sprite continueS;
    private Sprite tryS;
    private Texture background;
    private OrthographicCamera cam;
    private Viewport viewport;


    public LoseMenu(FallBall game){
        this.game=game;
        background=new Texture("background.png");
        loadButtons();
        cam=new OrthographicCamera();
        viewport=new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        viewport.apply();
        cam.position.set(cam.viewportWidth/2,cam.viewportHeight/2,0);
        cam.update();
        stage=new Stage(viewport,game.getBatch());
        Gdx.input.setInputProcessor(stage);





    }



    public void loadButtons(){
        Texture tryTex=new Texture("tryagain.png");
        tryS=new Sprite(tryTex,tryTex.getWidth(),tryTex.getHeight());
        tryS.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*tryS.getHeight()/tryS.getWidth());
        Texture continueTex=new Texture("continue.png");
        continueS=new Sprite(continueTex,continueTex.getWidth(),continueTex.getHeight());
        continueS.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*continueS.getHeight()/continueS.getWidth());


    }

    @Override
    public void show(){
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);


        Drawable tryDrawable = new SpriteDrawable(tryS);
        ImageButton tryButton = new ImageButton(tryDrawable);
        Drawable continueDrawable = new SpriteDrawable(continueS);
        ImageButton continueButton = new ImageButton(continueDrawable);

        tryButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                int i=Model.getInstance().getLevel();
                Model.getInstance().setLevel(i);
                Controller.newInstance();
                game.setScreen(new View(game));
            }
        });
        continueButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.MenuMusic.stop();
                game.setScreen(new MainMenu(game));
            }
        });
        table.add(tryButton).spaceBottom(100);
        table.row();
        table.add(continueButton);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT);
        game.getBatch().begin();
        game.getBatch().draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.getBatch().end();
        stage.act();
        stage.draw();
    }
    @Override
    public void dispose() {
        stage.dispose();
        background.dispose();
    }
}
