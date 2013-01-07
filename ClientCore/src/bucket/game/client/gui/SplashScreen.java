package bucket.game.client.gui;

/* 
 * Copyright (c) 2012 ***REMOVED***
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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * 
 * *Splash* is the sound that players make when their faces are thrown into this screen
 * 
 * @author: ***REMOVED***
 */

public class SplashScreen implements Screen {

  private Stage stage;
  private Skin skin;
  private Table table;

  @Override
  public void show() {
	stage = new Stage();
	Gdx.input.setInputProcessor(stage);

	skin = new Skin(Gdx.files.internal("assets/gui/uiskin.json"));
	table = new Table(skin);

  }

  public void render(float delta) {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	stage.draw();
	Table.drawDebug(stage);
  }

  // stage = new Stage();
  // Gdx.input.setInputProcessor(stage);
  // getClass();
  //
  // table = new Table();
  // skin = new Skin();
  //
  // table.setSkin(skin);
  // table.defaults().fill();
  // table.add("north").colspan(3);
  // table.row();
  // table.add("west");
  // table.add("center").expand();
  // table.add("east");
  // table.row();
  // table.add("south").colspan(3);

  @Override
  public void resize(int width, int height) {
	stage.setViewport(width, height, true);
  }

  // @Override
  // public void render(float delta) {
  // Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
  // stage.act(Gdx.graphics.getDeltaTime());
  // stage.draw();
  //
  // Table.drawDebug(stage);
  //
  // }

  @Override
  public void hide() {
  }

  @Override
  public void dispose() {
  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

}
