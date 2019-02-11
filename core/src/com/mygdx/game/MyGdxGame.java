package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.ArrayList;
import java.util.Random;


public class MyGdxGame extends ApplicationAdapter {
	//hello world
	SpriteBatch batch;
	Paddle player;
	Ball ball;
	Bricks bricks;
	Texture texture;
	public int x = 291;
	public static String [] powerups = new String[]{"magnet", "slow", "speed", "expand", "player","laser"};
	public static String powerup = "";
	ArrayList<Bullets> bullets;
	ArrayList<ArrayList<Bricks>> bricklist = new ArrayList<ArrayList<Bricks>>();

	int count = 0;
	int pos = 0;
	int animation = 2;

	public static Texture[] greendrop = new Texture[7];
    public static Texture[] reddrop = new Texture[7];
    public static Texture[] greydrop = new Texture[7];
    public static Texture[] orangedrop = new Texture[7];
    public static Texture[] pinkdrop = new Texture[7];
    public static Texture[] bluedrop = new Texture[7];
	@Override
	public void create() {
		texture = new Texture(Gdx.files.internal("Arkanoid1.png"));
		batch = new SpriteBatch();
		player = new Paddle(291,0);
		ball = new Ball(291, 10,ball.getDx(),ball.getDy());
		bullets = new ArrayList<Bullets>();

		for(int i = 0; i < 7; i ++){
			ArrayList<Bricks> bricks = new ArrayList<Bricks>();
			for(int j = 0; j < 14; j ++){
				if(i == 0) bricks.add(new Bricks("grey", j,i));
				if(i == 1) bricks.add(new Bricks("red",j,i));
				if(i == 2) bricks.add(new Bricks("yellow",j,i));
				if(i == 3) bricks.add(new Bricks("blue",j,i));
				if(i == 4) bricks.add(new Bricks("pink",j,i));
				if(i == 5) bricks.add(new Bricks("orange",j,i));
				if(i == 6) bricks.add(new Bricks("green",j,i));

                greendrop[i] = new Texture("greenpowerup/greenpowerup" + i + ".png");
                orangedrop[i] = new Texture("orangepowerup/orangepowerup" + i + ".png");
                pinkdrop[i] = new Texture("pinkpowerup/purplepowerup" + i + ".png");
                bluedrop[i] = new Texture("bluepowerup/bluepowerup" + i + ".png");
                greydrop[i] = new Texture("greypowerup/greypowerup" + i + ".png");
                reddrop[i] = new Texture("redpowerup/redpowerup" + i + ".png");
			}
			bricklist.add(bricks);
		}

	}

	@Override
	public void render() {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//keyboard control
		// shooting code

		//
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.getX() < 582) {
			x += 5;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.getX() > 25) {
			x -= 5;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.K)){
			powerup = powerups[3];
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.J)){
			powerup = powerups[2];
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.H)){
			powerup = powerups[1];
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.G)){
			powerup = powerups[5];

		}
		else if(Gdx.input.isKeyPressed(Input.Keys.F)){
			powerup = "";
		}

		//bullets
		if(powerup.equals("bullets") && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			bullets.add(new Bullets(player.getX() + 2));
			bullets.add(new Bullets(player.getX() + player.getWidth() - 2));

		}
		player.setX(x); // set the paddle to centre
		batch.begin();

		batch.draw(texture, 0, 0, 672, 768);
		player.update(batch,x,player.getY(),powerup);
		for(int i = 0; i < bricklist.size(); i ++){
			for(int j = 0; j < bricklist.get(i).size(); j ++){
				if(bricklist.get(i).get(j).collide(ball)){
					ball.dy = -2;
					bricklist.get(i).get(j).setGone(true);
				}
				for(int n = 0; n < bullets.size(); n ++){
					if(bricklist.get(i).get(j).bulletcollide(bullets.get(n))){
						bullets.remove(n);
						bricklist.get(i).get(j).setGone(true);
					}
				}
				bricklist.get(i).get(j).update(batch);
			}
		}
		//update
		for(int i = 0; i < bullets.size(); i ++){
			bullets.get(i).render(batch);
			bullets.get(i).update(batch);
			if(bullets.get(i).y > Gdx.graphics.getHeight()){
				bullets.remove(i);
			}
		}

        count += 1;
        if (count > animation) {
            count = 0;
            pos += 1;
            if (pos >= 3) {
                pos = 0;
            }
        }

		batch.end();
		ball.move(); // this will call the move method in the ball class

	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}
}
//hello