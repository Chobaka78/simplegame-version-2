package com.mygdx.game;

import java.awt.*;
import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bricks{
    // 2d list with corrisponding brick location
    private int [][] brickList= new int[][] {{4,4,4,4,4,4,4,4,4,4,4,4,4,4}, {7,7,7,7,7,7,7,7,7,7,7,7,7,7}, {8,8,8,8,8,8,8,8,8,8,8,8,8,8}, {1,1,1,1,1,1,1,1,1,1,1,1,1,1}, {6,6,6,6,6,6,6,6,6,6,6,6,6,6}, {3,3,3,3,3,3,3,3,3,3,3,3,3,3}};
    public static ArrayList<Point> getloc = new ArrayList<Point>(); // this list will get the sprite location
    private SpriteBatch batch;

    //creating the textures for the bricks
    private Texture bluebrick;
    private Texture darkbluebrick;
    private Texture greenbrick;
    private Texture greybrick;
    private Texture orangebrick;
    private Texture pinkbrick;
    private Texture redbrick;
    private Texture yellowbrick;

    //creating the sprites for the bricks
    private Sprite bluebrick_sprite;
    private Sprite darkbluebrick_sprite;
    private Sprite greenbrick_sprite;
    private Sprite greybrick_sprite;
    private Sprite orangebrick_sprite;
    private Sprite pinkbrick_sprite;
    private Sprite redbrick_sprite;
    private Sprite yellowbrick_sprite;

    private static final int GONE = 0;
    private static final int BLUE = 1;
    private static final int DARKBLUE = 2;
    private static final int GREEN = 3;
    private static final int GREY = 4;
    private static final int ORANGE = 5;
    private static final int PINK = 6;
    private static final int RED = 7;
    private static final int YELLOW = 8;


    public Bricks(){
        //loading all textures to sprites
        bluebrick_sprite = new Sprite(new Texture("bluebrick.png"));
        darkbluebrick_sprite = new Sprite(new Texture("darkbluebrick.png"));
        greenbrick_sprite = new Sprite(new Texture("greenbrick.png"));
        greybrick_sprite = new Sprite(new Texture("greybrick.png"));
        orangebrick_sprite = new Sprite(new Texture("orangebrick.png"));
        pinkbrick_sprite = new Sprite(new Texture("pinkbrick.png"));
        redbrick_sprite = new Sprite(new Texture("redbrick.png"));
        yellowbrick_sprite = new Sprite(new Texture("yellowbrick.png"));
        getloc = get_pos();
    }

    public ArrayList get_pos(){
        // beacuse all sprites are same size get the width and height of first brick
        int width = (int) bluebrick_sprite.getWidth();
        int height = (int) bluebrick_sprite.getHeight();
        ArrayList<Point> Pos = new ArrayList<Point>(); // make a position array list that will use the 2d bricklist
        int x = 10; // starting x pos
        int y = 710; // starting y pos
        // makes all the brick locations according to the 2d list
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 14; j++) {
                Point position = new Point((x + j * (width + 2)), (y - i * (height + 2)));
                Pos.add(position);
            }
        }
        return Pos; // returns the list
    }

    // renders the sprties
    private void render(SpriteBatch batch, int type){
        if(type == BLUE){
            bluebrick_sprite.draw(batch);
        }
        else if(type == DARKBLUE){
            darkbluebrick_sprite.draw(batch);
        }
        else if(type == GREEN){
            greenbrick_sprite.draw(batch);
        }
        else if(type == GREY){
            greybrick_sprite.draw(batch);
        }
        else if(type == ORANGE){
            orangebrick_sprite.draw(batch);
        }
        else if(type == PINK){
            pinkbrick_sprite.draw(batch);
        }
        else if(type == RED){
            redbrick_sprite.draw(batch);
        }
        else if(type == YELLOW){
            yellowbrick_sprite.draw(batch);
        }
    }

    // updates the sprites to make the multiple bricks
    public void update(SpriteBatch batch){
        int counter = 0;
        // makes the bricks
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 13; j++) {
                int brickType = brickList[i][j]; // brick type is extracted from the 2d list
                Point point = getloc.get(counter); // gets the location
                counter += 1;
                if (brickType == BLUE) {
                    bluebrick_sprite.setX(point.x);
                    bluebrick_sprite.setY(point.y);
                    this.render(batch, brickType); // renders the brick and its type
                }
                else if (brickType == DARKBLUE) {
                    darkbluebrick_sprite.setX(point.x);
                    darkbluebrick_sprite.setY(point.y);
                    this.render(batch, brickType);
                }
                else if (brickType == GREEN) {
                    greenbrick_sprite.setX(point.x);
                    greenbrick_sprite.setY(point.y);
                    this.render(batch, brickType);
                }
                else if (brickType == GREY) {
                    greybrick_sprite.setX(point.x);
                    greybrick_sprite.setY(point.y);
                    this.render(batch, brickType);
                }
                else if (brickType == ORANGE) {
                    orangebrick_sprite.setX(point.x);
                    orangebrick_sprite.setY(point.y);
                    this.render(batch, brickType);
                }
                else if (brickType == PINK) {
                    pinkbrick_sprite.setX(point.x);
                    pinkbrick_sprite.setY(point.y);
                    this.render(batch, brickType);
                }
                else if (brickType == RED) {
                    redbrick_sprite.setX(point.x);
                    redbrick_sprite.setY(point.y);
                    this.render(batch, brickType);
                }
                else if (brickType == YELLOW) {
                    yellowbrick_sprite.setX(point.x);
                    yellowbrick_sprite.setY(point.y);
                    this.render(batch, brickType);
                }

            }
        }
    }
}