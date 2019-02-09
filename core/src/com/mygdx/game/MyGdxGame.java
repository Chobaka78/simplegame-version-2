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


public class MyGdxGame extends ApplicationAdapter {
	//hello world
	SpriteBatch batch;
	Paddle player;
	Ball ball;
	Bricks bricks;
	Texture texture;
	public int x = 291;
	private static String powerup = "";
	ArrayList<Bullets> bullets;
	ArrayList<Bullets> removebullet = new ArrayList<Bullets>();

	@Override
	public void create() {
		texture = new Texture(Gdx.files.internal("Arkanoid1.png"));
		batch = new SpriteBatch();
		player = new Paddle(291,0);
		ball = new Ball(291, 10);
		bricks = new Bricks();
		bullets = new ArrayList<Bullets>();

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
			powerup = "expand";
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.L)){
			powerup = "magnet";
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.J)){
			powerup = "speed";
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.H)){
			powerup = "slow";
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.G)){
			powerup = "bullets";

		}
		else if(Gdx.input.isKeyPressed(Input.Keys.F)){
			powerup = "";
		}

		//bullets
		if(powerup.equals("bullets") && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			bullets.add(new Bullets(player.getX()));
			bullets.add(new Bullets(player.getX() + player.getWidth()));

		}
		//update
		for(Bullets bullet : bullets){
			bullet.update(batch);
			if(bullet.remove){
				removebullet.add(bullet);
			}
		}
		bullets.removeAll(removebullet);

		player.setX(x); // set the paddle to centre
		batch.begin();

		batch.draw(texture, 0, 0, 672, 768);
		player.update(batch,x,player.getY(),powerup);
		bricks.update(batch);
		for(Bullets bullet : bullets){
			bullet.render(batch);
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