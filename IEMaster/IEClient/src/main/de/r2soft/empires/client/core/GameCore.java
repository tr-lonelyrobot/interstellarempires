/* #########################################################################
 * Copyright (c) 2013 Random Robot Softworks
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
 * 
 ######################################################################### */
package de.r2soft.empires.client.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;

import de.r2soft.empires.client.resources.SettingsInterface;
import de.r2soft.empires.client.resources.Values;
import de.r2soft.empires.client.screens.utilities.IntroductionScreen;
import de.r2soft.empires.client.screens.utilities.LoginScreen;

/**
 * 
 * Called when the game is created. Handles all Screen activity for the game.
 * 
 * @author: ***REMOVED***
 */
public class GameCore extends R2Core {

  private Music music;
  private static GameCore game = null;

  private GameCore() {
	super();
  }

  /**
   * 
   * @return The game core.
   */
  public static GameCore getInstance() {
	if (game == null)
	  game = new GameCore();
	return game;
  }

  /** Called every frame to check if something needs to be changed (Screen resolution/ music/ etc.) */
  public void update() {
	if (SettingsInterface.getInstance().getBoolean(Values.PREFERENCE_PLAY_MUSIC)) {
	  if (!music.isPlaying()) {
		music.play();
		music.setLooping(true);
		music.setVolume(0.95f);
	  }
	}
	else {
	  if (music.isPlaying())
		music.stop();
	}
  }

  @Override
  public void create() {
	super.create();

	music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music/intro_music.mp3"));

	if (!SettingsInterface.getInstance().contains(Values.PREFERENCE_PLAY_MUSIC))
	  SettingsInterface.getInstance().putBoolean(Values.PREFERENCE_PLAY_MUSIC, true);

	if (!SettingsInterface.getInstance().contains(Values.PREFERENCE_SKIP_INTRO))
	  SettingsInterface.getInstance().putBoolean(Values.PREFERENCE_SKIP_INTRO, true);

	if (!SettingsInterface.getInstance().containsList(Values.PREFERENCE_LIST_SERVERS)) {
	  String[] servers = new String[2];
	  servers[0] = "Ergosphere (Official):empires.2rsoftworks.de/ergosphere:10052:10053";
	  servers[1] = "Local (Personal):localhost:10052:10053";
	  SettingsInterface.getInstance().putList(servers, Values.PREFERENCE_LIST_SERVERS);
	}

	if (!SettingsInterface.getInstance().getBoolean(Values.PREFERENCE_SKIP_INTRO))
	  setScreen(new IntroductionScreen());
	else
	  setScreen(new LoginScreen());
  }

  @Override
  public void render() {
	super.render();
	update();
  }

  @Override
  public void dispose() {
	super.dispose();
	if (SettingsInterface.getInstance().getBoolean(Values.PREFERENCE_PLAY_MUSIC))
	  music.stop();
  }

  @Override
  public void resize(int width, int height) {
	super.resize(width, height);
  }

  @Override
  public void pause() {
	super.pause();

	if (SettingsInterface.getInstance().getBoolean(Values.PREFERENCE_PLAY_MUSIC))
	  music.pause();
  }

  @Override
  public void resume() {
	super.resume();
	if (SettingsInterface.getInstance().getBoolean(Values.PREFERENCE_PLAY_MUSIC))
	  music.play();
  }

}
