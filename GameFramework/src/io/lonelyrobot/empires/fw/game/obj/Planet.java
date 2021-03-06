/* #########################################################################
 * Copyright (c) 2017 Lonely Robot
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

package io.lonelyrobot.empires.fw.game.obj;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import io.lonelyrobot.empires.fw.game.map.OrbitData;
import io.lonelyrobot.empires.fw.game.traits.Celestial;
import io.lonelyrobot.empires.fw.game.traits.Orbitable;
import io.lonelyrobot.empires.fw.game.traits.Ownable;

/**
 * 
 * @author Katharina 'spacekookie' Fey <kookie@spacekookie.de>
 */
public class Planet extends BaseObject implements Celestial, Ownable, Orbitable {

  public Planet(Star parent, float orbitRadius, Vector2D position) {

    /** Setup planet with all required fields now */
    super.orbit = new OrbitData();
    orbit.setParent(parent);
    orbit.setRadius(orbitRadius);

    super.setSolPos(position);
  }

}
