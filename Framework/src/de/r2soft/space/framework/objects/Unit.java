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

package de.r2soft.space.framework.objects;

import de.r2soft.space.framework.players.Player;

/**
 * @author Leander
 * 
 */
public class Unit extends MovingObject {

	/** For testing only */
	public static enum TYPE {
		FLEET, SHIP, DEBRIS, PONY;
	}

	public static enum FLEET_SIZE {
		TINY, SMALL, MEDIUM, LARGE, MASSIVE;
	}

	private TYPE type;
	private String flag;
	private Player claim;
	private int count;

	public Unit() {
		count = 1;
	}

	/**
	 * Determines what icon size will be used for rendering.
	 * 
	 * @return enum for fleet SIZE.
	 */
	public FLEET_SIZE getFleetSize() {
		if (count < 10)
			return FLEET_SIZE.TINY;
		if (count < 25)
			return FLEET_SIZE.SMALL;
		if (count < 50)
			return FLEET_SIZE.MEDIUM;
		if (count < 100)
			return FLEET_SIZE.LARGE;
		if (count < 500)
			return FLEET_SIZE.MASSIVE;
		else
			return null;
	}

	public void setShipCount(int count) {
		this.count = count;
	}

	public void addShip() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Player getClaim() {
		return claim;
	}

	public void setClaim(Player claim) {
		this.claim = claim;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

}