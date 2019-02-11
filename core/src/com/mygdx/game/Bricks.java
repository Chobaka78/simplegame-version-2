package com.mygdx.game;

import java.awt.*;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.mygdx.game.Powerups.power;

public class Bricks{
    // 2d list with corrisponding brick location
    public static int x,y;
    private Sprite brick;
    private Texture blueBrick, greenBrick, greyBrick, redBrick, pinkBrick, orangeBrick, yellowBrick;
    public Rectangle rect;
    public boolean gone = false;
    int speed = 2;
    Powerups power;

    private int hitx, hity;
    Random rand = new Random();
    int score = 0;
    int n = rand.nextInt(10) + 1;
    int r = rand.nextInt(5) + 1;

    public static boolean powergone = false;

    private boolean isdone = false;



    public Bricks(String type, int x, int y){
        //loading all textures to the object array list
        blueBrick = new Texture("Bricks/bluebrick.png");
        greenBrick = new Texture("Bricks/greenbrick.png");
        greyBrick = new Texture("Bricks/greybrick.png");
        redBrick = new Texture("Bricks/redbrick.png");
        pinkBrick = new Texture("Bricks/pinkbrick.png");
        orangeBrick = new Texture("Bricks/orangebrick.png");
        yellowBrick = new Texture("Bricks/yellowbrick.png");



        if(type.equals("blue")){
            brick = new Sprite(blueBrick);
        }
        else if (type.equals("green")){
            brick = new Sprite(greenBrick);
        }
        else if (type.equals("grey")){
            brick = new Sprite(greyBrick);
        }
        else if (type.equals("red")){
            brick = new Sprite(redBrick);
        }
        else if (type.equals("pink")){
            brick = new Sprite(pinkBrick);
        }
        else if (type.equals("orange")){
            brick = new Sprite(orangeBrick);
        }
        else if (type.equals("yellow")){
            brick = new Sprite(yellowBrick);
        }

        brick.setPosition((40 + x * 42)  , 705 - y * 20);
        rect = new Rectangle((int) brick.getX(), (int) brick.getY(), (int) brick.getWidth(), (int) brick.getHeight());



    }


    // renders the sprties
    private void render(SpriteBatch batch){
        rect = new Rectangle((int) brick.getX(), (int) brick.getY(), (int) brick.getWidth(), (int) brick.getHeight());
        brick.draw(batch);
    }

    // updates the sprites to make the multiple bricks
    public void update(SpriteBatch batch){


        if(this.getGone()){
            brick.setAlpha(0);

        }
        this.render(batch);
    }

    public Rectangle getRect(){
        return rect;
    }

    public boolean collide (Ball ball){
        return Ball.ball.getBoundingRectangle().overlaps(brick.getBoundingRectangle()) && !this.getGone();

    }


    public boolean bulletcollide(Bullets bullet){
        return bullet.getRect().intersects(this.getRect()) && !this.getGone();

    }

    public boolean getGone(){
        return gone;
    }

    public void setGone(boolean gone){
        this.gone = gone;

    }





}
