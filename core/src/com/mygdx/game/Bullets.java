package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullets {
    public static final int speed = 10;
    public static final int defaultY = 40;
    private static Texture img;
    float x,y;
    static Sprite bullet;
    public boolean remove = false;

    public Bullets (float x){
        this.x = x;
        this.y = defaultY;

        if(img == null){
            img = new Texture("bullet.png");
        }

    }

    public void update(SpriteBatch batch){
        y += speed;
        if (y > Gdx.graphics.getHeight()){
            remove = true;
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(img, x, y);
    }
}
