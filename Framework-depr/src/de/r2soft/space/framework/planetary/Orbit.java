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

package de.r2soft.space.framework.planetary;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.r2soft.space.framework.objects.BaseObject;
import de.r2soft.space.framework.objects.OrbitalObject;

/**
 * Creates a basic orbit for a planet or moon
 * 
 * @author Katharina
 * 
 */
public class Orbit {

  public static enum ORBIT_TYPE {
	CIRCULAR, ELLIPTICAL, ESCAPING;
  }

  private ORBIT_TYPE type;
  private float radius;
  private OrbitalObject self;
  private BaseObject parent;

  /** Try avoid using as it leaves self and parent empty */
  public Orbit(ORBIT_TYPE type) {
	this(type, 1);
  }

  /** Try avoid using as it leaves self and parent empty */
  public Orbit(ORBIT_TYPE type, float radius) {
	this.type = type;
	this.radius = radius;
  }

  /**
   * Creates a new Orbit with all neccesary values. Avoid using other constructors or changing values with setters.
   * 
   * @param type
   *          The type of orbit that needs to be attached
   * @param radius
   *          The radius of the orbit around a parent meassured from it's semi-major axis center
   * @param self
   *          The object that owns this orbit
   * @param parent
   *          The object that is being orbited.
   */
  public Orbit(ORBIT_TYPE type, float radius, OrbitalObject self, BaseObject parent) {
	this.type = type;
	this.radius = radius;
	this.self = self;
	this.parent = parent;
  }

  /** Returns SOMETHING */
  public Vector2D getNextStep() {
	return null;
  }

  public void drawDebug(float deltaTime) {

  }

  public ORBIT_TYPE getType() {
	return type;
  }

  public void setType(ORBIT_TYPE type) {
	this.type = type;
  }

  public float getRadius() {
	return radius;
  }

  public void setRadius(float radius) {
	this.radius = radius;
  }

  public OrbitalObject getSelf() {
	return self;
  }

  public void setSelf(OrbitalObject self) {
	this.self = self;
  }

  public BaseObject getParent() {
	return parent;
  }

  public void setParent(BaseObject parent) {
	this.parent = parent;
  }

}
