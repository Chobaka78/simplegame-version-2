package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;


public class Ball {
    private static int x, y;
    public static int dx = 10, dy = 2;
    public boolean play = false;
    private Texture img;
    static Sprite ball;
    private SpriteBatch batch;
    Paddle player;
    int score = 0;
    public static Rectangle rect;
    boolean mag = false;
    public static int speedx= 3;
    public static int speedy= 3;
    Bricks bricks;


    public Ball (int x, int y,int dx, int dy){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.play = play;
        this.speedx = speedx;
        this.speedy = speedy;
        img = new Texture(Gdx.files.internal("ball.png"));
        ball = new Sprite(img);
        batch = new SpriteBatch();
        rect = new Rectangle(x,y,9,9);
    }

    public void render(int x, int y){
        batch.begin();
        ball.setPosition(x,y);
        ball.draw(batch);

        batch.end();
    }


    public void move() {
        // this method will move the ball and also render it on to the screen

        if(!play){
            render(player.getX() + player.getWidth()/2 -2,player.getY() + player.height);
            x = player.getX() + player.getWidth()/2 - 2;
            y = player.getY() + player.height;
            dx = 1; dy = 2;
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
                play = true;


            }
        }
        if(play){


            if(play && ball.getBoundingRectangle().overlaps(Paddle.player.getBoundingRectangle())){
                dy = -dy;
            }
            if(getX() < 25){
                dx = -dx;
            }
            if(getX() > 642){
                dx = -dx;
            }
            if(getY() < 0){
                if(play){
                    play = false;
                    MyGdxGame.powerup = "";
                }
           }

            if(getY() > 735){
                dy = -dy;
            }
            x += dx*speedx;
            y += dy*speedy;
            render(x, y);


        }


    }

    public static int getX(){
        return x;
    }

    public static int getY(){
        return y;
    }

    public static int getDx(){
        return dx;

    }

    public static int getDy(){
        return dy;
    }

    public static Rectangle getRect(){
        return rect;
    }
}
