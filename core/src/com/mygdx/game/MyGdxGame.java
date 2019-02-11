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
	Powerups power;
	Texture texture;
	Texture menu;
	public int x = 291;
	int score =0 ;
	public static String [] powerups = new String[]{"magnet", "slow", "speed", "expand", "player","laser"};
	public static String powerup = "";
	ArrayList<Bullets> bullets;
	public static ArrayList<ArrayList<Bricks>> bricklist = new ArrayList<ArrayList<Bricks>>();
	ArrayList<Powerups>POWERUPS = new ArrayList<Powerups>();
	Random rand = new Random();
	public boolean hit = false;
	public static int deadx, deady;

	BitmapFont font;
	boolean game = false ;


	@Override
	public void create() {
		font = new BitmapFont();
		menu = new Texture(Gdx.files.internal("menu.png"));
		texture = new Texture(Gdx.files.internal("Arkanoid1.png"));
		batch = new SpriteBatch();
		player = new Paddle(291,0);
		power = new Powerups();
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

			}
			bricklist.add(bricks);
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		System.out.println(powerup);
		//keyboard control
		// shooting code

		//
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.getX() < 582) {
			x += 5;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.getX() > 25) {
			x -= 5;
		}

		//bullets
		if(powerup.equals("bullets") && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			bullets.add(new Bullets(player.getX() + 2));
			bullets.add(new Bullets(player.getX() + player.getWidth() - 2));

		}
		player.setX(x); // set the paddle to centre
		batch.begin();
		batch.draw(menu, 0,0,672,768);
		      if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
		      	game = true;

			  }
		if (game = true ) {
			batch.draw(texture, 0, 0, 672, 768);
			font.draw(batch, "score = "+ score, 300, 740);

		}
		int drop = rand.nextInt(1000);
		if(drop < 350 && hit && POWERUPS.size() == 0) {
			POWERUPS.add(new Powerups());
		}
		else{
			hit = false;
		}
		for(int m = 0; m < POWERUPS.size(); m ++){
			POWERUPS.get(m).update(batch);
			if(POWERUPS.get(m).collide(player)){
				powerup = powerups[power.getType()];
				POWERUPS.remove(m);
				hit = false;
			}
			else if(POWERUPS.get(m).getRect().y + POWERUPS.get(m).getRect().height < 0){
				POWERUPS.remove(m);
				hit = false;
			}
		}

		player.update(batch,x,player.getY(),powerup);
		for(int i = 0; i < bricklist.size(); i ++){
			for(int j = 0; j < bricklist.get(i).size(); j ++){
				if(bricklist.get(i).get(j).collide(ball)){
					ball.dy = -2;
					score +=100;
					hit = true;
					deadx = bricklist.get(i).get(j).rect.x;
					deady = bricklist.get(i).get(j).rect.y;
					bricklist.get(i).get(j).setGone(true);
				}
				for(int n = 0; n < bullets.size(); n ++){
					if(bricklist.get(i).get(j).bulletcollide(bullets.get(n))){
						bullets.remove(n);
						score +=100;
						hit = true;
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