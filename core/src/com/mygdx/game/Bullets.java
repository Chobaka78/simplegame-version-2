package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Bullets {
    public static final int speed = 10;
    public static final int defaultY = 40;
    private static Texture img;
    float x,y;
    static Sprite bullet;
    public boolean remove = false;
    public Rectangle bulletrect;

    public Bullets (float x){
        this.x = x;
        this.y = defaultY;
        bulletrect = new Rectangle((int)x, (int) y,3,9);
        if(img == null){
            img = new Texture("bullet.png");
            bullet = new Sprite(img);
        }

    }

    public void render(SpriteBatch batch){
        bullet.draw(batch);
    }

    public void update(SpriteBatch batch ){
        y += speed;
        if (y > Gdx.graphics.getHeight()){
            remove = true;
        }
        bullet.setPosition(x,y);
        this.render(batch);
    }

    public Rectangle getRect(){
        return bulletrect;
    }
}
