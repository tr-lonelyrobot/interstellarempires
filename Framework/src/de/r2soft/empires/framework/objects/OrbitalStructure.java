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

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.r2soft.space.framework.objects.factory.UnitFactory;
import de.r2soft.space.framework.planetary.Orbit;
import de.r2soft.space.framework.planetary.Orbit.ORBIT_TYPE;
import de.r2soft.space.framework.players.Player;

public class OrbitalStructure extends OrbitalObject {

  /** The type of station */
  public static enum StationType {
	IHUB, FACTORY_SMALL, FACTORY_CAPITAL, MILITARY_SMALL;
  }

  private UnitFactory factory;

  public OrbitalStructure(Category category, StationType type, Player claim, Vector2D position) {
	super.setCategory(category);

	/** Should the structure have a unit factory? */
	if (type.equals(StationType.FACTORY_SMALL) || type.equals(StationType.FACTORY_CAPITAL) || type.equals(StationType.MILITARY_SMALL)) {
	  factory = new UnitFactory(claim, this);
	}

	super.setClaim(claim);
	super.setPosition(position);
	super.orbit = new Orbit(ORBIT_TYPE.CIRCULAR, getOrbitalR(), this, getParent());
  }

  /** Check if the structure has a UnitFactory */
  public boolean hasFactory() {
	return factory == null ? false : true;
  }

  /** @return UnitFactory if exists. Can be null */
  public UnitFactory getFactory() {
	return hasFactory() ? factory : null;
  }
}