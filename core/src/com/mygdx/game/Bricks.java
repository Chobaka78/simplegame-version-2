package com.mygdx.game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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
    public Rectangle rect;
    public boolean gone = false;
    int speed = 5;
    int count = 0;
    int pos = 0;
    int animation = 2;
    int vy;
    private int hitx, hity;

    Random rand = new Random();

    public static boolean powergone = false;

    private boolean isdone = false;

    public static ArrayList<Sprite> powerups = new ArrayList<Sprite>();


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
        if(this.getGone() && !isdone) {
            if (pos == 7) isdone = true;
            vy -= speed;
            powerups.add(new Sprite(MyGdxGame.greendrop[pos]));
            powerups.add(new Sprite(MyGdxGame.orangedrop[pos]));
            powerups.add(new Sprite(MyGdxGame.pinkdrop[pos]));
            powerups.add(new Sprite(MyGdxGame.bluedrop[pos]));
            powerups.add(new Sprite(MyGdxGame.greydrop[pos]));
            powerups.add(new Sprite(MyGdxGame.reddrop[pos]));
            int r = rand.nextInt(5);
            powerups.get(r).setX(hitx);
            powerups.get(r).setY(vy);
            powerups.get(r).draw(batch);

        }

    }

    private void renderPowerup(SpriteBatch batch){

    }

    // updates the sprites to make the multiple bricks
    public void update(SpriteBatch batch){
        if(this.getGone()){
            brick.setAlpha(0);
            count += 1;
            if (count > animation) {
                count = 0;
                pos += 1;
                if (pos >= 7) {
                    pos = 0;
                }
            }

            for(int i = 0; i < powerups.size(); i ++){
                if (Paddle.player.getBoundingRectangle().overlaps(powerups.get(i).getBoundingRectangle())){
                    System.out.println(powerups.size());
                    powerups.remove(i);
                    System.out.println(powerups.size());
                    MyGdxGame.powerup = "magnet";

                }
            }

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
        hitx = getRect().x;
        hity = getRect().y;
        vy = hity;
    }



}
