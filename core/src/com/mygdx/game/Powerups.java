package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.Random;

public class Powerups {
    static Sprite power;
    private Texture sprite;
    public Rectangle rect;
    private static int x,y,type,speed;
    Random rand = new Random();
    public Bricks bricks;
    public int vx,vy;


    public Powerups(){
        Texture [] img = {new Texture("powerups/greenpowerup.png"), new Texture("powerups/orangepowerup.png"), new Texture("powerups/pinkpowerup.png"), new Texture("powerups/bluepowerup.png"), new Texture("powerups/greypowerup.png"), new Texture("powerups/redpowerup.png")};
        type = rand.nextInt(img.length);
        sprite = img[type];
        power  = new Sprite(sprite);
        // fall speed
        speed = 3;
        x = MyGdxGame.deadx;
        y = MyGdxGame.deady;
        power.setX(x);
        power.setY(y);
        rect = new Rectangle((int)power.getX(), (int)power.getY(),(int) power.getWidth(),(int) power.getHeight());
    }

    public void render(SpriteBatch batch){
        power.draw(batch);
    }

    public void update(SpriteBatch batch) {
        power.setY(power.getY() - speed);
        rect = new Rectangle((int)power.getX(), (int)power.getY(),(int) power.getWidth(),(int) power.getHeight());
        this.render(batch);
    }

    public boolean collide(Paddle player){
        return Paddle.player.getBoundingRectangle().overlaps(power.getBoundingRectangle());
    }

    public Rectangle getRect(){
        return rect;
    }

    public int getType (){
        return type;
    }

}
