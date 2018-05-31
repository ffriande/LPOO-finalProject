package com.mygdx.fallball.view.Buttons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.fallball.FallBall;

public abstract class ButtonView {
    Vector2 pos;
    Texture texture;
    float width;
    ButtonView(Vector2 pos,float width){
        this.pos=pos;
        this.width=width;
        createTexture();
    }

    public abstract void createTexture();
    public abstract void setScreen(FallBall game);

    public void dispose(){
        texture.dispose();
    }

    public boolean checkTouch(float x,float y){
        if(x>(pos.x-width/2)&&x<(pos.x+width/2)&&y>(pos.y-width*texture.getHeight()/texture.getWidth()/2)&&y<(pos.y+width*texture.getHeight()/texture.getWidth()/2))
            return true;
        return false;
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture,pos.x-width/2,pos.y-width*texture.getHeight()/texture.getWidth()/2,width,width*texture.getHeight()/texture.getWidth());
    }

}
