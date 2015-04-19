package test;

import roadNetwork.LinkType;
import roadNetwork.Location;
import roadNetwork.TrafficNetwork;

public class First {

	public static void main(String[] args) {

		TrafficNetwork trafficNetwork = new TrafficNetwork();
		Location linz = new Location(300, 80, "Linz");
		Location wels = new Location(240, 90, "Wels");
		Location sattledt = new Location(230, 110, "Sattledt");
		Location freistadt = new Location(200, 70, "Freistadt");
		Location steyermuhl = new Location(250, 120, "Steyermuhl");
		Location kirchdorf = new Location(150, 60, "kirchdorf");
		trafficNetwork.addLocation(linz);
		trafficNetwork.addLocation(wels);
		trafficNetwork.addLocation(sattledt);
		trafficNetwork.addLocation(freistadt);
		trafficNetwork.addLocation(steyermuhl);
		trafficNetwork.addLocation(kirchdorf);

		trafficNetwork.addLink("A9", LinkType.AUTOBAHN, 52, linz,wels);
		trafficNetwork.addLink("B310", LinkType.BUNDESSTRASSE, 45, linz,freistadt);
		trafficNetwork.addLink("A1", LinkType.AUTOBAHN, 58, linz,sattledt);
		trafficNetwork.addLink("A8", LinkType.AUTOBAHN, 58, wels,sattledt);
		trafficNetwork.addLink("A1", LinkType.AUTOBAHN, 22, steyermuhl,sattledt);
		trafficNetwork.addLink("A8", LinkType.AUTOBAHN, 45, kirchdorf,sattledt);
		
	}

}
