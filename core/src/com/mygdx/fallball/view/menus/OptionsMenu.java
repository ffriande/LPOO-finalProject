package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
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

public class OptionsMenu extends ScreenAdapter {
    private FallBall game;
    private Stage stage;
    private Sprite MuteSprite;
    private Sprite returnSprite;
    private Texture background;
    private OrthographicCamera cam;
    private Viewport viewport;
    private ImageButton muteButton;


    public OptionsMenu(FallBall game){
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
        Texture MuteTex=new Texture("sound.png");
        MuteSprite =new Sprite(MuteTex,MuteTex.getWidth(),MuteTex.getHeight());
        MuteSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*MuteSprite.getHeight()/MuteSprite.getWidth());
        Texture returnTex=new Texture("return.png");
        returnSprite =new Sprite(returnTex,returnTex.getWidth(),returnTex.getHeight());
        returnSprite.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*returnSprite.getHeight()/returnSprite.getWidth());

    }

    @Override
    public void show(){
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        final Drawable muteDrawable = new SpriteDrawable(MuteSprite);
        muteButton = new ImageButton(muteDrawable);
        Drawable returnDrawable = new SpriteDrawable(returnSprite);
        ImageButton returnButton = new ImageButton(returnDrawable);

        muteButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(View.VOLUME==0f){
                    View.VOLUME=1f;
                    MainMenu.MenuMusic.loop(View.VOLUME);
                }else {
                    MainMenu.MenuMusic.stop();
                    View.VOLUME = 0f;
                }
            }
        });
        returnButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.MenuMusic.stop();
                game.setScreen(new MainMenu(game));
            }
        });
        table.add(muteButton).spaceBottom(100);
        table.row();
        table.add(returnButton);
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

        //setScreen(new View(this));

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
