package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Bullets {
    public static final int speed = 10;
    public static final int defaultY = 12;
    private static Texture img;
    float x,y;
    static Sprite bullet;
    public boolean remove = false;
    public Rectangle bulletrect;
    Bricks brick;

    public Bullets (float x){
        this.x = x;
        this.y = defaultY;
        bulletrect = new Rectangle((int)x, (int) y,3,9);
        img = new Texture("bullet.png");
        bullet = new Sprite(img);

    }

    public void render(SpriteBatch batch){
        bulletrect = new Rectangle((int)x, (int) y,3,9);
        bullet.draw(batch);
    }

    public void update(SpriteBatch batch){
        y += speed;
        bullet.setPosition(x,y);
        this.render(batch);
    }

    public Rectangle getRect(){
        return bulletrect;
    }
}
