package test;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

import roadNetwork.LinkType;
import roadNetwork.Link;
import roadNetwork.Location;
import roadNetwork.TrafficNetwork;

public class First {

	public static void main(String[] args) {

		TrafficNetwork trafficNetwork = new TrafficNetwork();
		Location linz = new Location(300, 80, "Linz");
		Location wels = new Location(240, 90, "Wels")
		trafficNetwork.addLocation(linz);
		trafficNetwork.addLocation(wels);
		
		linz.addLink();
//		trafficNetwork.addLocation(new Location(230, 110, "Sattledt"));
		

	}

}
