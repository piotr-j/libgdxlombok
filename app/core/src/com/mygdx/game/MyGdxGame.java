package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.extern.java.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log
public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");



		TestThing thing = new TestThing();
		thing.setThingy(1.2f);
		Gdx.app.log("Hello", "thing 1: " + thing + ", thingy = " + thing.getThingy());
		Gdx.app.log("Hello", "thing 2:  " + new TestThing(2.4f));
		Gdx.app.log("Hello", "value: " + new TestValue(4.8f));
		Gdx.app.log("Hello", "data: " + new TestData(6.123f));

		// seems its undefined by default on gwt? perhaps there is something about that in the docs i didnt quite read
		// same on ios? meh
//		log.setLevel(Level.ALL);
//		log.log(Level.INFO, "Hello from @Log ??");

//		Logger logger = Logger.getLogger("Logger person");
//		logger.log(Level.SEVERE, "Hello from logger??");

		// who knows if this owrks on android
		TestMapper mapper = TestMapper.INSTANCE;
		TestThingDTO value = new TestThingDTO(1.0f);
		TestThing from = mapper.from(value);
		TestThingDTO to = mapper.to(from);

		Gdx.app.log("hello", value + " == " + to);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

}
