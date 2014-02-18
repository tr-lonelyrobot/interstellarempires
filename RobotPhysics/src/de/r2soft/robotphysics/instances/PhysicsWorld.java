/* #########################################################################
 * Copyright (c) 2014 Random Robot Softworks
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

package de.r2soft.robotphysics.instances;

import java.util.HashSet;
import java.util.Set;

public class PhysicsWorld {

  private Set<PhysicsBody> children;

  public PhysicsWorld() {
	children = new HashSet<PhysicsBody>();
  }

  /** Update movement for each body */
  public void update(float delta) {

  }

  public void addChild(PhysicsBody child) {
	if (!children.contains(child))
	  children.add(child);
  }

  public void removeChild(PhysicsBody child) {
	if (children.contains(child))
	  children.remove(child);
  }

  public Set<PhysicsBody> getChildren() {
	return children;
  }

}