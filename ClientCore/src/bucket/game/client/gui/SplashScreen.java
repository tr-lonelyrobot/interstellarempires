package bucket.game.client.gui;

/* 
 * Copyright (c) 2012 Katharina Fey
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
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * 
 * Splash Screen into which the players gets thrown on launch. Yes. THROWN! Violently!
 * 
 * @author: Katharina
 */

public class SplashScreen implements Screen {

  private Stage stage;

  @Override
  public void show() {
	stage = new Stage();
	Gdx.input.setInputProcessor(stage);

	Table table = new Table();
	table.setFillParent(true);
	stage.addActor(table);

	// TODO: Actually add stuff here

  }

  @Override
  public void resize(int width, int height) {
	stage.setViewport(width, height, true);
  }

  @Override
  public void render(float delta) {
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	stage.act(Gdx.graphics.getDeltaTime());
	stage.draw();

	Table.drawDebug(stage);

  }

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
