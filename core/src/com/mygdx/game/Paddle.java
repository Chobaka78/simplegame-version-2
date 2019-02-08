package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import sun.java2d.windows.GDIBlitLoops;

import java.util.ArrayList;


public class Paddle {
    private static int x, y;
    public static int width, height;
    private Texture img, img1;
    static Sprite player, player1;
    private  SpriteBatch batch;
    public static int [] VausType = new int[] {0,1};
    public static ArrayList<Sprite> Vaus = new ArrayList<Sprite>();
    private static ArrayList<Texture> load = new ArrayList<Texture>();
    public static int Vaustype;

    public Paddle (){
        Paddle.x = x;
        Paddle.y = y;
        Paddle.width = 500;
        Paddle.height = 12;
        load.add(img = new Texture("player.png"));
        load.add(img = new Texture("player1.png"));
        player = new Sprite(img);
        for(int i = 0; i < load.size(); i ++){
            Vaus.add(new Sprite(load.get(i)));
        }

        batch = new SpriteBatch();
    }

    public void render(SpriteBatch batch, int type){
        for( int i = 0; i < Vaus.size(); i ++){
            if(type == VausType[i]){
                Vaus.get(type).draw(batch);
            }
        }

    }
    public void update(SpriteBatch batch, int x, int y){
        if(Gdx.input.isKeyPressed(Input.Keys.K)){
            Vaustype = 1;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.L)){
            Vaustype = 0;
        }
        for(int i = 0; i < Vaus.size(); i ++){
            if(Vaustype == VausType[i]){
                Vaus.get(Vaustype).setPosition(x,y);
                this.render(batch,Vaustype);
            }
        }
    }


    public static int getX(){
        return x;
    }

    public static int getY(){
        return y;
    }

    public void setX(int x){
        Paddle.x = x;
    }

}
