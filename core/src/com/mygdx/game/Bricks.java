package com.mygdx.game;

import java.awt.*;
import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bricks{
    // 2d list with corrisponding brick location
    private static int x,y, width, height;
    private Sprite brick;
    private Texture blueBrick;
    private Texture greenBrick;
    private Texture greyBrick;
    private Texture redBrick;
    private Texture pinkBrick;
    private Texture orangeBrick;
    private Texture yellowBrick;
    private Rectangle rect;




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
        this.render(batch);
    }

    public boolean collide (Ball ball){
        return Ball.ball.getBoundingRectangle().overlaps(brick.getBoundingRectangle());
    }

    public void brickremove(){
        brick.setAlpha(0);
        brick.setPosition(1000,1000);
    }

    public boolean bulletcollide(Bullets bullets){
        return Bullets.bullet.getBoundingRectangle().overlaps(brick.getBoundingRectangle());
    }


}
