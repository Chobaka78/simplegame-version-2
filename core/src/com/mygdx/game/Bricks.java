package com.mygdx.game;

import java.awt.*;
import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bricks{
    private Texture load;
    private ArrayList<Texture> img;
    private static int x, y;
    public int brick_diff;
    public static int width, height;
    static ArrayList<Sprite> bricks = new ArrayList<Sprite>();
    static Sprite brick;
    private  SpriteBatch batch;

    public Bricks(int x, int y){
        this.x = x;
        this.y = y;
        img = new ArrayList<Texture>();
            img.add(load = new Texture("bluebrick.png"));
            img.add(load = new Texture("darkbluebrick.png"));
            img.add(load = new Texture("greenbrick.png"));
            img.add(load = new Texture("greybrick.png"));
            img.add(load = new Texture("orangebrick.png"));
            img.add(load = new Texture("pinkbrick.png"));
            img.add(load = new Texture("redbrick.png"));
            img.add(load = new Texture("yellowbrick.png"));


        for (int i = 0; i < img.size(); i ++){
            brick = new Sprite(img.get(i));
            bricks.add(brick);
        }
        batch = new SpriteBatch();
    }

    public void render(int x, int y, int brick_diff){
        batch.begin();
            if (bricks.get(brick_diff) != null) {
                bricks.get(brick_diff).draw(batch);
                bricks.get(brick_diff).setPosition(35, 600);
            }
        batch.end();

    }

    public static int getX(){
        return x;
    }

    public static int getY(){
        return y;
    }

    public void setAmount (int brick_diff){
        this.brick_diff = brick_diff;
    }

    public void setX (int x){
        this.x = x;
    }

    public void setY (int y){
        this.y = y;
    }

}