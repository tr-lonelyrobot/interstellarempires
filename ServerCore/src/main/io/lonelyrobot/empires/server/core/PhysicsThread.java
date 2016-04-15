/* #########################################################################
 * Copyright (c) 2014 RANDOM ROBOT SOFTWORKS
 * (See @authors file)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ######################################################################### */

package io.lonelyrobot.empires.server.core;

/**
 * @author Katharina Fey <kookie@spacekookie.de>
 */
public class PhysicsThread extends Thread {

  @Override
  public void start() {
	System.out.print("[Physics]: Building entity tree...");

	// TODO: Load all physics instances here.

	System.out.println("[DONE]");

	setDaemon(true);
	System.out.println("[Physics]: This is now a daemon thread.");
	super.start();
  }

  @Override
  public void run() {
	// System.out.println("[Physics]: I am still alive!");
  }

}
