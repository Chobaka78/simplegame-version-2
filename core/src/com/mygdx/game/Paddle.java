package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Paddle {
    private static int x, y;
    public static int width, height;
    private Texture img;
    static Sprite player;
    private  SpriteBatch batch;

    public Paddle (int x, int y){
        Paddle.x = x;
        Paddle.y = y;
        Paddle.width = 500;
        Paddle.height = 12;
        img = new Texture("player.png");
        player = new Sprite(img);
        batch = new SpriteBatch();
    }

    public void render(int x, int y){
        batch.begin();
        player.setPosition(x,y);
        player.draw(batch);
        batch.end();

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
