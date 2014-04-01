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
package de.r2soft.empires.client.screens.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import de.r2soft.empires.client.core.CoreGame;
import de.r2soft.empires.client.screens.gameplay.HexMapScreen;
import de.r2soft.empires.client.settings.BaseSettings;
import de.r2soft.empires.client.settings.Resources;
import de.r2soft.empires.client.settings.Sizes;

/**
 * This screen will enable the user to change stuff about their game client
 * 
 * @author Katharina
 * 
 */
public class SettingsScreen implements Screen {

  /** Container and Backends */
  private Stage stage;
  private TextButton button;
  private Table table;
  private Table navigation;
  private Preferences prefs;

  private CheckBox skipIntro, playMusic;

  public SettingsScreen() {
	Gdx.graphics.setTitle(BaseSettings.SUPERTITLE + " - " + BaseSettings.VERSION_NUMBER + " - " + BaseSettings.SCREENTITLE_SETTINGS);
	prefs = Gdx.app.getPreferences(BaseSettings.PREFERENCE_FILE_NAME);

	skipIntro = new CheckBox("Skip the intro", Resources.UI_SKIN);
	playMusic = new CheckBox("Play background music", Resources.UI_SKIN);

	if (prefs.contains(BaseSettings.PREFERENCE_SKIP_INTRO))
	  skipIntro.setChecked(prefs.getBoolean(BaseSettings.PREFERENCE_SKIP_INTRO));

	if (prefs.contains(BaseSettings.PREFERENCE_PLAY_MUSIC))
	  playMusic.setChecked(prefs.getBoolean(BaseSettings.PREFERENCE_PLAY_MUSIC));
  }

  @Override
  public void render(float delta) {
	Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	stage.act(delta);
	stage.draw();

	if (skipIntro.isChecked()) {
	  prefs.putBoolean(BaseSettings.PREFERENCE_SKIP_INTRO, true);
	}
	else {
	  prefs.putBoolean(BaseSettings.PREFERENCE_SKIP_INTRO, false);
	}

	if (playMusic.isChecked()) {
	  prefs.putBoolean(BaseSettings.PREFERENCE_PLAY_MUSIC, true);
	}
	else {
	  prefs.putBoolean(BaseSettings.PREFERENCE_PLAY_MUSIC, false);
	}

	skipIntro.setChecked(prefs.getBoolean(BaseSettings.PREFERENCE_SKIP_INTRO));
	playMusic.setChecked(prefs.getBoolean(BaseSettings.PREFERENCE_PLAY_MUSIC));

	/** What do we do after we're done in the bathroom? :) */
	prefs.flush();

  }

  @Override
  public void resize(int width, int height) {
	if (stage == null)
	  stage = new Stage(width, height, true);
	stage.clear();

	// Collect touchdown events
	Gdx.input.setInputProcessor(stage);
	stage.setViewport(width, height, true);

	navigation = new Table();
	navigation.setFillParent(true);
	stage.addActor(navigation);
	button = new TextButton("Back to main screen", Resources.UI_SKIN);

	navigation.add(button).width(Sizes.SIZE_UI_BUTTON_NAVIGON);
	navigation.row();

	navigation.top().right();

	stage.addActor(navigation);

	button.addListener(new InputListener() {
	  public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		return true;
	  }

	  public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		CoreGame.getInstance().onUpdate();
		CoreGame.getInstance().setScreen(new HexMapScreen(prefs.getString(BaseSettings.PREFERENCE_SAVED_USER_NAME)));
	  }
	});

	/** Settings Table */

	table = new Table();
	table.setFillParent(true);

	table.add(skipIntro).left();
	table.row();
	table.add(playMusic).left();
	table.row();
	table.center();
	stage.addActor(table);

	Table credits = new Table(Resources.UI_SKIN);
	credits.setBackground("default-window");
	credits.setSize(325, 125);
	credits.bottom().left();
	credits.add(new Label("Credits", Resources.UI_SKIN)).colspan(2).center();
	credits.row();
	credits.add(new Label("Leander Sabel", Resources.UI_SKIN)).left().width(150);
	credits.add(new Label("Coding", Resources.UI_SKIN)).left();
	credits.row();
	credits.add(new Label("Katharina Fey", Resources.UI_SKIN)).left().width(150);
	credits.add(new Label("Coding & Graphics", Resources.UI_SKIN)).left();
	credits.row();
	credits.add(new Label("Steve Teufel", Resources.UI_SKIN)).left().width(150);
	credits.add(new Label("Sounds & Music", Resources.UI_SKIN)).left();
	credits.row();
	credits.add(new Label("(c)2013 Random Robot Softworks", Resources.UI_SKIN)).colspan(2).left();
	credits.row();
	stage.addActor(credits);

  }

  @Override
  public void show() {
	// TODO Auto-generated method stub

  }

  @Override
  public void hide() {
	// TODO Auto-generated method stub

  }

  @Override
  public void pause() {
	// TODO Auto-generated method stub

  }

  @Override
  public void resume() {
	// TODO Auto-generated method stub

  }

  @Override
  public void dispose() {
	// TODO Auto-generated method stub

  }

}
