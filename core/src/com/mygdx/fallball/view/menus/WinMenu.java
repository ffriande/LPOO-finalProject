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

public class WinMenu extends ScreenAdapter {
    private FallBall game;
    private Stage stage;
    private Sprite continueS;
    private Sprite levelS;
    private Texture background;


    public WinMenu(FallBall game){
        this.game=game;
        background=new Texture("background.png");
        loadButtons();
        OrthographicCamera cam=new OrthographicCamera();
        Viewport viewport=new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), cam);
        viewport.apply();
        cam.position.set(cam.viewportWidth/2,cam.viewportHeight/2,0);
        cam.update();
        stage=new Stage(viewport,game.getBatch());
        Gdx.input.setInputProcessor(stage);





    }



    private void loadButtons(){
        Texture levelTex=new Texture("LevelMode.png");
        levelS=new Sprite(levelTex,levelTex.getWidth(),levelTex.getHeight());
        levelS.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*levelS.getHeight()/levelS.getWidth());
        Texture continueTex=new Texture("continue.png");
        continueS=new Sprite(continueTex,continueTex.getWidth(),continueTex.getHeight());
        continueS.setSize(MainMenu.ButtonsWidth,MainMenu.ButtonsWidth*continueS.getHeight()/continueS.getWidth());


    }

    @Override
    public void show(){
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);

        Drawable levelDrawable = new SpriteDrawable(levelS);
        ImageButton levelButton = new ImageButton(levelDrawable);
        Drawable continueDrawable = new SpriteDrawable(continueS);
        ImageButton continueButton = new ImageButton(continueDrawable);

        levelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LevelMenu(game));
            }
        });
        continueButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MainMenu.MenuMusic.stop();
                game.setScreen(new MainMenu(game));
            }
        });

        table.add(levelButton).spaceBottom(100);
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

        //setScreen(new View(this));

    }
    @Override
    public void dispose() {
        stage.dispose();
        background.dispose();
    }
}
