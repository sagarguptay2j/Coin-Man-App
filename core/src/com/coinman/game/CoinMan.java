package com.coinman.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CoinMan extends ApplicationAdapter {
	SpriteBatch batch;
	Texture backGround;
	Texture[] frame;
	int manState=0;
	int x=0;
	@Override
	public void create () {
		batch = new SpriteBatch();
		backGround = new Texture("bg.png");
		frame=new Texture[4];
		frame[0]=new Texture("frame-1.png");
		frame[1]=new Texture("frame-2.png");
		frame[2]=new Texture("frame-3.png");
		frame[3]=new Texture("frame-4.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (x<8){
			x++;
		}
		else {
			x=0;
			batch.draw(backGround, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			if (manState < 3)
				manState++;
			else
				manState = 0;
			batch.draw(frame[manState], Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 3);
			batch.end();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backGround.dispose();
	}
}
