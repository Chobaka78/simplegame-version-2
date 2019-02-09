package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Paddle {
    private static int x, y;
    public static int width, height;
    public static String powerup;
    private Texture img, img1;
    private static boolean mag = false;
    static Sprite player;
    Ball ball;

    public Paddle (int x, int y){
        this.x = x;
        this.y = y;
        this.height = 12;
        Paddle.powerup = "";
        img = new Texture("player1.png");
        player = new Sprite(img);
    }

    public void render(SpriteBatch batch){
       player.draw(batch);

    }
    public void update(SpriteBatch batch, int x, int y, String powerup){

        if(powerup.equals("")){
           player.setSize(64,12);
           player.setPosition(x,y);
           render(batch);
       }

       else if(powerup.equals("expand")){
           player.setSize(100,12);
           player.setPosition(x,y);
           render(batch);
       }

       else if(powerup.equals("magnet")){
           mag = true;
           if(mag && Ball.ball.getBoundingRectangle().overlaps(player.getBoundingRectangle())){
               Ball.ball.setPosition(player.getX() + player.getWidth()/2 - 2,player.getY() + height);
           }
           player.setPosition(x,y);
           render(batch);
        }

       else if(powerup.equals("speed")){
            ball.speedx = 10;
            ball.speedy = 10;
            player.setPosition(x,y);
            render(batch);
        }

       else if(powerup.equals("slow")){
           ball.speedx = 1;
           ball.speedy = 1;
           player.setPosition(x,y);
           render(batch);
        }

       else if(powerup.equals("bullets")){
            player.setPosition(x,y);
            render(batch);
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

    public static int getWidth(){
        return (int) player.getWidth();
    }

}
