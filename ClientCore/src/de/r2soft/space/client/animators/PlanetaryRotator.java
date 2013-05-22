/* 
 * Copyright (c) 2013 Katharina Fey
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

package de.r2soft.space.client.animators;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Creates circular movement for celestial bodies and space stations.
 * 
 * @author Katharina
 * 
 */
public class PlanetaryRotator implements TweenAccessor<Sprite> {

	private float angle;

	public void setRotationAngle(float angle) {
		this.angle = angle;
	}

	@Override
	public int getValues(Sprite target, int tweenType, float[] returnValues) {
		return 0;
	}

	@Override
	public void setValues(Sprite target, int tweenType, float[] newValues) {

	}

}