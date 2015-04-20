package test;

import java.util.List;

import inout.In;
import roadNetwork.LengthComp;
import roadNetwork.Link;
import roadNetwork.LinkType;
import roadNetwork.Location;
import roadNetwork.TrafficNetwork;

public class First {

	public static void main(String[] args) {

		TrafficNetwork trafficNetwork = new TrafficNetwork();
		Location linz = new Location(300, 80, "Linz");
		Location wels = new Location(240, 190, "Wels");
		Location sattledt = new Location(230, 310, "Sattledt");
		Location freistadt = new Location(400, 270, "Freistadt");
		Location steyermuhl = new Location(250, 520, "Steyermuhl");
		Location kirchdorf = new Location(350, 560, "Kirchdorf");
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

		System.out
				.println("====================================================");
		Location current, init;
		init = linz;
		System.out.println("Roundtrip starting at " + init.getName());
		System.out
				.println("====================================================");
		current = linz;
		do {

			System.out.println(current.toString());
//			List<Link> duplicate = current.getLinkedSorted(new LengthComp());
//			for (Link l : duplicate) {
//				System.out.println(l.toString(current));
//			}
			Location currentLocation = current;
			current.getLinkedSorted(new LengthComp()).forEach(l -> System.out.println(l.toString(currentLocation) + "\t" + l.getTravelTimeInHours()));

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
