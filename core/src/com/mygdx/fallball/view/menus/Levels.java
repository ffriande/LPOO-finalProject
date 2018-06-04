package com.mygdx.fallball.view.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

/**
 * Levels.java-Reads and writes in files.
 * Has the number of unlocked levels and the number total of levels.
 * Needed to use in the LevelMenu.
 * @see Json.Serializable
 */
public class Levels implements Json.Serializable {
    private static Levels instance;
    private int nrUnlocked;
    private int nrLevels;
    private Json json;

    /**
     * Class constructor.
     * Checks if the file exists.
     * If it doesn't creates it and starts the variables using standard values.
     */
    private Levels(){
        json=new Json();
        nrUnlocked=1;
        nrLevels=4;
        if(!Gdx.files.local("levels.json").exists())
            write(json);
        readJson(json.fromJson(String.class,Gdx.files.local("levels.json")));
    }

    /**
     * Gets the number of levels unlocked
     * @return int data type.
     */
    public int getNrUnlocked(){
        return nrUnlocked;
    }

    /**
     * Gets the number of levels.
     * @return int data type.
     */
    public int getNrLevels(){
        return nrLevels;
    }

    /**
     * @return Json data type.
     */
    public Json getJson(){
        return this.json;
    }

    /**
     * Resets all the values to standard.
     */
    public void resetLevels(){
        nrUnlocked=1;
        nrLevels=4;
        write(json);
    }

    /**
     * Increments the number of unlocked levels.
     */
    public void increaseNrUnlocked(){
        this.nrUnlocked++;
    }

    /**
     * If instance does not exist creates a new one.
     * Returns this instance.
     * @return Levels data type.
     */
    public static Levels getInstance(){
        if (instance == null)
            instance = new Levels();
        return instance;
    }

    /**
     * Decipher the string to initialize the values nrLevels and nrUnlocked.
     * @param s A variable of type String.
     */
    private void readJson(String s){
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
