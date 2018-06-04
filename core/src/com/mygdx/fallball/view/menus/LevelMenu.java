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
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.fallball.FallBall;
import com.mygdx.fallball.controller.Controller;
import com.mygdx.fallball.model.Model;
import com.mygdx.fallball.view.View;

public class LevelMenu extends ScreenAdapter{

    private FallBall game;
    private Stage stage;
    private Sprite levelS[];
    private ImageButton buttons[];
    private Texture background;
    private OrthographicCamera cam;
    private Viewport viewport;

    public LevelMenu(FallBall game){
        this.game=game;
        background=new Texture("background.png");
        levelS=new Sprite[Levels.getInstance().getNrLevels()];
        buttons=new ImageButton[Levels.getInstance().getNrLevels()];
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
        for(int i=0;i<Levels.getInstance().getNrUnlocked();i++) {
            String name="level"+(i+1)+".png";
            Texture Leveltex = new Texture(name);
            levelS[i] = new Sprite(Leveltex, Leveltex.getWidth(), Leveltex.getHeight());
            levelS[i].setSize(MainMenu.ButtonsWidth/2, MainMenu.ButtonsWidth/2 * levelS[i].getHeight() / levelS[i].getWidth());
        }

        for(int i=Levels.getInstance().getNrUnlocked();i<Levels.getInstance().getNrLevels();i++){
            Texture lockedtex=new Texture("locked.png");
            levelS[i]=new Sprite(lockedtex,lockedtex.getWidth(),lockedtex.getHeight());
            levelS[i].setSize(MainMenu.ButtonsWidth/2, MainMenu.ButtonsWidth/2 * levelS[i].getHeight() / levelS[i].getWidth());
        }


    }

    @Override
    public void show(){
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        for(int i=0;i<Levels.getInstance().getNrLevels();i++) {
            Drawable LevelDrawable = new SpriteDrawable(levelS[i]);
            ImageButton Levelbutton = new ImageButton(LevelDrawable);
            buttons[i]=Levelbutton;
        }
        for(int i=0;i<Levels.getInstance().getNrUnlocked();i++) {
            final int u=i+1;
            buttons[i].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Model.getInstance().setLevel(u);
                    Controller.newInstance();
                    game.setScreen(new View(game));
                }
            });
        }
        int u=0;
        for(int i=0;i<buttons.length;i++) {
            table.add(buttons[i]).center().space(50);
            u++;
            if(u%2==0)
                table.row();
        }
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
