package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Ball {
    private static int x, y, dx = -1, dy = 2;
    public boolean play = false;
    private Texture img;
    static Sprite ball;
    private SpriteBatch batch;
    Paddle player;
    int score = 0;
    BitmapFont font;
    boolean mag = false;
    int speedx= 3;
    int speedy= 3;


    public Ball (int x, int y){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        img = new Texture(Gdx.files.internal("ball.png"));
        ball = new Sprite(img);
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    public void render(int x, int y){
        batch.begin();
        ball.setPosition(x,y);
        ball.draw(batch);
        font.draw(batch, "score = "+ score, 300, 740);
        batch.end();
    }

    public static int getX(){
        return x;
    }

    public static int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }


    public void move() { // this method will move the ball and also render it on to the screen

        if(!play){
            render(player.getX() + 27,player.getY() + player.height);
            x = player.getX() + 27;
            y = player.getY() + player.height;
            dx = -1; dy = 2;
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            play = true;
            }
        }
        if(play){
            if(Gdx.input.isKeyPressed(Input.Keys.B)){
                speedx = 10;
                speedy =10;
            }

            if(Gdx.input.isKeyPressed(Input.Keys.N)){
                mag = true;
            }
            if (mag == true &&play && ball.getBoundingRectangle().overlaps(Paddle.player.getBoundingRectangle())) {
                play = false;
            }

            if(play && ball.getBoundingRectangle().overlaps(Paddle.player.getBoundingRectangle())){
                dy = -dy;
                score+=10;



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
}
