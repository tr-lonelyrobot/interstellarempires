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
package de.r2soft.space.client.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import javax.jws.WebMethod;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.log4j.Logger;

import de.r2soft.space.framework.map.Map;
import de.r2soft.space.framework.map.SolarSystem;
import de.r2soft.space.framework.objects.GameObject;
import de.r2soft.space.framework.objects.PlayerObject;
import de.r2soft.space.framework.players.Player;
import de.r2soft.space.framework.primitives.IntVec2;
import de.r2soft.space.server.ws.interfaces.ConnectionService;
import de.r2soft.space.server.ws.interfaces.GameObjectService;
import de.r2soft.space.server.ws.interfaces.MapService;

<<<<<<< HEAD
public class WebServiceClient implements ConnectionService, GameObjectService, MapService {
=======
public class WebServiceClient {
>>>>>>> develop

	private static WebServiceClient uniqInstance;

	private static String WSDL_BASE_URL = "http://localhost:8080/ServerWS/";
	private final Logger log = Logger.getLogger(this.getClass());

	private ConnectionService connectionClient;
	private GameObjectService gameObjectClient;

	private Integer sessionID;

<<<<<<< HEAD
	private WebServiceClient() {
		try {
			QName connectionServiceName = new QName("http://2rSoftworks.de/", "ConnectionService");
			QName gameObjectServiceName = new QName("http://2rSoftworks.de/", "GameObjectService");
=======
  private WebServiceClient() {
	// Initialize variables
	sessionID = -1;

	try {
	  QName connectionServiceName = new QName("http://2rSoftworks.de/", "ConnectionService");
	  QName gameObjectServiceName = new QName("http://2rSoftworks.de/", "GameObjectService");
>>>>>>> develop

			URL connectionServiceWsdl = new URL(WSDL_BASE_URL + connectionServiceName.getLocalPart()
					+ "?wsdl");
			URL gameObjectServiceWsdl = new URL(WSDL_BASE_URL + gameObjectServiceName.getLocalPart()
					+ "?wsdl");

			Service connectionService = Service.create(connectionServiceWsdl, connectionServiceName);
			Service gameObjectService = Service.create(gameObjectServiceWsdl, gameObjectServiceName);

			connectionClient = connectionService.getPort(ConnectionService.class);
			gameObjectClient = gameObjectService.getPort(GameObjectService.class);
		}
		catch (MalformedURLException e) {
			log.error("Invalid wsdl URL", e);
		}
	}

	/**
	 * Get a handle to this singleton WebService client.
	 * 
	 * @return
	 */
	public static synchronized WebServiceClient getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new WebServiceClient();
		}
		return uniqInstance;
	}

	/**
	 * Get the session ID used to request information from the server.
	 * 
	 * @return
	 */
	public Integer getSessionID() {
		return sessionID;
	}

	@Override
	@WebMethod
	public Integer connect(String username, String password) {
		return connectionClient.connect(username, password);
	}

	@Override
	@WebMethod
	public boolean disconnect(Integer sessionID) {
		return connectionClient.disconnect(sessionID);
	}

	@Override
	@WebMethod
	public Set<GameObject> getGlobalGameObjects(Integer sessionID) {
		return gameObjectClient.getGlobalGameObjects(sessionID);
	}

	@Override
	@WebMethod
	public Set<PlayerObject> getPlayerObjects(Integer sessionID) {
		return gameObjectClient.getPlayerObjects(sessionID);
	}

	@Override
	@WebMethod
	public Set<PlayerObject> getObjectsInSystem(Integer sessionID, IntVec2 system) {
		return gameObjectClient.getObjectsInSystem(sessionID, system);
	}

	public static void main(String[] args) {
		WebServiceClient client = WebServiceClient.getInstance();
		System.out.println(client.connect("Bob", "*****"));
	}

	@Override
	@WebMethod
	public Set<SolarSystem> getGlobalSolarSystems(Integer sessionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod
	public Set<SolarSystem> getPlaySolarSystems(Integer sessionID, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod
	public Set<SolarSystem> getKnownSolarSystems(Integer sessionID, Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod
	public Map getPlayerViewScreen(IntVec2 bottomLeftSystem, float mapWidth, float mapHeight) {
		// TODO Auto-generated method stub
		return null;
	}
<<<<<<< HEAD
=======
	return uniqInstance;
  }

  /**
   * Get the session ID used to request information from the server.
   * 
   * @return
   */
  public Integer getSessionID() {
	return sessionID;
  }

  /**
   * Connect to the webserver
   * 
   * @param username
   * @param password
   * @return
   */
  public boolean connect(String username, String password) {
	sessionID = connectionClient.connect(username, password);
	return sessionID != -1;
  }

  public boolean disconnect() {
	return connectionClient.disconnect(sessionID);
  }

  public Set<GameObject> getGlobalGameObjects() {
	return gameObjectClient.getGlobalGameObjects(sessionID);
  }

  public Set<PlayerObject> getPlayerObjects() {
	return gameObjectClient.getPlayerObjects(sessionID);
  }

  public Set<PlayerObject> getObjectsInSystem(IntVec2 system) {
	return gameObjectClient.getObjectsInSystem(sessionID, system);
  }

  public static void main(String[] args) {
	WebServiceClient client = WebServiceClient.getInstance();
	System.out.println(client.connect("Bob", "*****"));
  }
>>>>>>> develop

}
