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



public class MyGdxGame extends ApplicationAdapter {
	//hello world
	SpriteBatch batch;
	Paddle Vaus;
	Ball ball;
	Bricks bricks;
	Texture texture;
	public int x = 291, width;
	public boolean play = false;

	@Override
	public void create() {
		texture = new Texture(Gdx.files.internal("Arkanoid1.png"));
		batch = new SpriteBatch();
		Vaus = new Paddle();
		ball = new Ball(Vaus.getX() + 27, 10);
		bricks = new Bricks();

	}

	@Override
	public void render() {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//keyboard control
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && Vaus.getX() < 582) {
			x += 5;


		} else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && Vaus.getX() > 25) {
			x -= 5;
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.K)){
			width = 600;
		}
		Vaus.setX(x); // set the paddle to centre
		batch.begin();

		batch.draw(texture, 0, 0, 672, 768);
		Vaus.update(batch,x,Vaus.getY());
		bricks.update(batch);
		batch.end();
		ball.move(); // this will call the move method in the ball class

	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

}