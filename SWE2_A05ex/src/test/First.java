package test;

import inout.In;
import roadNetwork.LengthComp;
import roadNetwork.LinkType;
import roadNetwork.Location;
import roadNetwork.TrafficNetwork;
//import roadNetwork.TravelTimeInHoursComp;

/**
 * First.java
 *
 * A {@link First} is a test class. It inserts new locations and links, and ask
 * the user where he/she would like to go next.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class First {

	public static void main(String[] args) {

		TrafficNetwork trafficNetwork = new TrafficNetwork();
		Location linz = new Location(300, 80, "Linz");
		Location wels = new Location(240, 190, "Wels");
		Location sattledt = new Location(230, 310, "Sattledt");
		Location freistadt = new Location(400, 270, "Freistadt");
		Location steyermuhl = new Location(250, 520, "Steyermuhl");
		Location kirchdorf = new Location(350, 560, "Kirchdorf");
		Location verona = new Location(700, 500, "Verona");
		trafficNetwork.addLocation(linz);
		trafficNetwork.addLocation(wels);
		trafficNetwork.addLocation(sattledt);
		trafficNetwork.addLocation(freistadt);
		trafficNetwork.addLocation(steyermuhl);
		trafficNetwork.addLocation(kirchdorf);

		trafficNetwork.addLink("A9", LinkType.AUTOBAHN, 52, linz, wels);
		trafficNetwork.addLink("B310", LinkType.BUNDESSTRASSE, 45, linz,
				freistadt);
		trafficNetwork.addLink("A1", LinkType.AUTOBAHN, 58, linz, sattledt);
		trafficNetwork.addLink("A8", LinkType.AUTOBAHN, 58, wels, sattledt);
		trafficNetwork
				.addLink("A1", LinkType.STRASSE, 22, steyermuhl, sattledt);
		trafficNetwork
				.addLink("A8", LinkType.AUTOBAHN, 45, kirchdorf, sattledt);
		trafficNetwork.addLink("A22", LinkType.AUTOBAHN, 600, linz, verona);

		System.out
				.println("====================================================");
		Location current, init;
		init = linz;
		System.out.println("Roundtrip starting at " + init.getName());
		System.out
				.println("====================================================");
		current = linz;
		do {

			System.out.println(current.locationToString());
			Location currentLocation = current;
			current.getLinkedSorted(new LengthComp()).forEach(
					l -> System.out.println(l.linkToString(currentLocation)));
			// current.getLinkedSorted(new TravelTimeInHoursComp()).forEach(l ->
			// System.out.println(l.linkToString(currentLocation)));
			System.out.println();
			System.out.print("Next location: ");
			String newPlace = In.readWord();
			current = trafficNetwork.getLocation(newPlace);
			System.out.println();
		} while (!current.equals(init));

		System.out.println("You are back in " + init.getName());
		System.out
				.println("====================================================");
	}

}
