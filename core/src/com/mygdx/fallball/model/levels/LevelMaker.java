package com.mygdx.fallball.model.levels;

import com.badlogic.gdx.utils.Json;
import com.mygdx.fallball.model.entities.FinalPlatformModel;
import com.mygdx.fallball.model.entities.NormalPlatformModel;
import com.mygdx.fallball.model.entities.PlatformModel;
import com.mygdx.fallball.model.entities.RedPlatformModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.naming.Context;

import static com.mygdx.fallball.view.View.PIXEL_TO_METER;
import static com.mygdx.fallball.view.View.VIEWPORT_WIDTH;

public class LevelMaker {
    public final static float DISTANCE_BETWEEN_PLATFORMS = 30;
    public final static float FIRST_PLATFORM_Y = 25;
    public final static float PLATFORM_HEIGHT=3;
    //TODO:fazer mais alguns levels
    //TODO:pensar no algoritmo para o infinite mode
    //TODO:acabar de meter musica
    //TODO:meter highscore


    private List<TemplateContainer> definied = new ArrayList<TemplateContainer>();
    private List<PlatformModel> platforms=new ArrayList<PlatformModel>();

    public LevelMaker(int difficulty){
        //readSer(difficulty);
        //createTemplateCont();
        //saveSer();
        switch(difficulty){
            case 1:
                level1();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        /*
        for(TemplateContainer t:
        saveSer(fileName);
         */
    }
    public List<PlatformModel> getPlatforms() {
        return platforms;
    }

    private void readSer(int difficulty){
        for(int u=0;u<difficulty;u++) {
            String fileName="level" + String.valueOf(difficulty) + ".ser";
            TemplateContainer t = null;
            try {
                FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                t = (TemplateContainer) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("PlatformTemplate class not found");
                c.printStackTrace();
                return;
            }
            definied.add(t);
        }
    }

  /* private void createTemplateCont(){
        List<PlatformTemplate> templates=new ArrayList<PlatformTemplate>();
        List<PlatformModel> plat=new ArrayList<PlatformModel>();
        PlatformTemplate p=new PlatformTemplate();
        NormalPlatformModel n=new NormalPlatformModel(2.5f,0,5,3);
        plat.add(n);
        NormalPlatformModel n1=new NormalPlatformModel(29.5f,0,41,3);
        plat.add(n1);
        p.setPlatforms(plat);
        templates.add(p);
        TemplateContainer t=new TemplateContainer();
        t.setAll(1,templates);
        definied.add(t);

    }*/

    private void saveSer(){
        Json json=new Json();
        for(TemplateContainer it:definied) {
            String name="level"+String.valueOf(it.getDifficulty())+".txt";

            /*try {
                FileOutputStream fileOut =new FileOutputStream("level1.txt");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(it);
                out.close();
                fileOut.close();
                System.out.printf("Serialized data is saved in " + name);
            } catch (IOException i) {
                i.printStackTrace();
            }*/

        }
    }

    private void level1(){
        TemplateContainer t=new BeginCreator(0);
        definied.add(t);
        platforms=t.getTemplates().get(0).getPlatforms();
        TemplateContainer g=new Level1Creator(1);
        definied.add(g);
        g.getTemplates().get(0).setY(t.getTemplates().get(0).getLastY()-DISTANCE_BETWEEN_PLATFORMS);
        platforms.addAll(g.getTemplates().get(0).getPlatforms());
        /*PlatformTemplate help=definied.get(0).getTemplates().get(0);
        help.setY(FIRST_PLATFORM_Y);
        for(PlatformModel it:help.getPlatforms())
            platforms.add(it);*/
            /*float y=35/PIXEL_TO_METER, x=0;
            for (int i = 0; i < 100; i++){
                x=0;
                if(i%10!=0){
                  PlatformModel platform = new NormalPlatformModel(x,y,5/PIXEL_TO_METER,1/PIXEL_TO_METER);
                  this.platforms.add(platform);}
                else{
                    PlatformModel platform = new RedPlatformModel(x,y,5/PIXEL_TO_METER,1/PIXEL_TO_METER, false);
                    this.platforms.add(platform);}
                }
                y-=10/PIXEL_TO_METER;
                *//*if(x>=20/PIXEL_TO_METER)
                    x=10/PIXEL_TO_METER;
                else*//*
                x+=randomX();*/
        /*float width=5f, height=3;
        float y=FIRST_PLATFORM_Y, x=width/2;//ter a certeza que nao fica de fora

        NormalPlatformModel platform1= new NormalPlatformModel(10,y,width,height);
        this.platforms.add(platform1);

//        for (int j = 0; j < 3; j++){//3 mundos
//            x=-VIEWPORT_WIDTH+width/2f+VIEWPORT_WIDTH*j;
//            y=FIRST_PLATFORM_Y;
        for (int i = 0; i < 5; i++){
                       //3 mundos
            PlatformModel platform;

          if(y==25 || y==-15)
                platform = new RedPlatformModel(x,y,width,height,4f);
            else if(i==4)
                 platform=new FinalPlatformModel(VIEWPORT_WIDTH/2,y,5 );
            else
                platform = new NormalPlatformModel(x,y,width,height);

            this.platforms.add(platform);
            x+=width; //step do x
            y-=DISTANCE_BETWEEN_PLATFORMS;
//                if(j==0)
//                    if(x+width/2f>=0){
//                        System.out.println("\n\n\nPROXIMA LINHA j=0");
//                    x=-VIEWPORT_WIDTH+width/2f+VIEWPORT_WIDTH*j;
//                        continue;}
//                else if(j==1)
                    if(x+width/2f>=VIEWPORT_WIDTH){
                    System.out.println("\n\n\nPROXIMA LINHA j=1");
                        x=width/2f;
                        }
//                else{
//                    if(x+width/2f>=VIEWPORT_WIDTH*2){
//                        System.out.println("\n\n\nPROXIMA LINHA j=2");
//                        x=-VIEWPORT_WIDTH+width/2f+VIEWPORT_WIDTH*j;
//                continue;}}
//        }
        //3 mundos
        }*/
    }

    //TODO: fazer função auxiliar de randomize para o x das plataformas, tal como para as red plats

    private float randomX(){
        Random r = new Random();
        return (r.nextInt((10+1)+5)/PIXEL_TO_METER);
    }


}
