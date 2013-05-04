/* 
 * Copyright (c) 2013 ***REMOVED***
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package client.core;

import client.screens.MenuScreen;
import client.screens.TweenScreen;
import client.settings.Settings;
import client.util.ResourcePacker;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

/**
 * 
 * Called when the game is created. Handles all Screen activity for the game. Further functionality might be added in the future
 * 
 * @author: ***REMOVED***
 */
public class ScreenHandler extends Game {

	private static ScreenHandler handler;

	/**
	 * 
	 * Returns The Games screenhandler to start new screens from actors, groups and sub-classes. Accessed in a static way.
	 * 
	 * @return The main Screenhandler.
	 */
	public static ScreenHandler getInstance() {
		return handler;
	}

	private void loadAssets() {
		ResourcePacker pack = new ResourcePacker();
		Gdx.app.log(Settings.LOG, "Textures loaded");
	}

	@Override
	public void create() {
		handler = this;

		this.loadAssets();

		if (!Settings.skipIntro)
			setScreen(new TweenScreen(this));
		else
			setScreen(new MenuScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

}
