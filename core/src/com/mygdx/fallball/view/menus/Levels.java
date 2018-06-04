package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.fallball.model.Model;

import java.util.logging.FileHandler;

public class Levels implements Json.Serializable {
    private static Levels instance;
    private int nrUnlocked;
    private int nrLevels;
    private Json json;

    private Levels(){
        json=new Json();
        nrUnlocked=1;
        nrLevels=4;
        if(!Gdx.files.local("levels.json").exists())
            write(json);
        readJson(json.fromJson(String.class,Gdx.files.local("levels.json")));
    }

    public int getNrUnlocked(){
        return nrUnlocked;
    }

    public int getNrLevels(){
        return nrLevels;
    }

    public Json getJson(){
        return this.json;
    }

    public void increaseNrUnlocked(){
        this.nrUnlocked++;
    }


    public static Levels getInstance(){
        if (instance == null)
            instance = new Levels();
        return instance;
    }


    public void readJson(String s){
        nrLevels=Integer.parseInt(s.substring(0,s.indexOf(";")));
        nrUnlocked=Integer.parseInt(s.substring(s.indexOf(";")+1,s.indexOf(";",2)));
    }
    @Override
    public void write(Json json) {
        String s;
        s=nrLevels + ";" + nrUnlocked+";";
        String levels =json.toJson(s,String.class);
        FileHandle file=Gdx.files.local("levels.json");
        file.writeString(levels,false);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {

    }
}
