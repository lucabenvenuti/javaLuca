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
		Location wels = new Location(240, 90, "Wels");
		Location sattledt = new Location(230, 110, "Sattledt");
		Location freistadt = new Location(200, 70, "Freistadt");
		Location steyermuhl = new Location(250, 120, "Steyermuhl");
		Location kirchdorf = new Location(150, 60, "Kirchdorf");
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
		trafficNetwork.addLink("A1", LinkType.AUTOBAHN, 22, steyermuhl,
				sattledt);
		trafficNetwork
				.addLink("A8", LinkType.AUTOBAHN, 45, kirchdorf, sattledt);
		
		
		System.out.println("====================================================");
		Location current, init;
		init = linz;
		System.out.println("Roundtrip starting at " + init.getName());
		System.out.println("====================================================");
		current = linz;
		do{
		
		System.out.println(current.toString());
		List<Link> duplicate = current.getLinkedSorted(new LengthComp());
		for (Link l : duplicate) {
			System.out.println(l.toString(current));
		}


		// current.getLinkedSorted(new LengthComp()).stream().forEach(p ->
		// System.out.println(p.toString(current)));

		System.out.println();
		System.out.print("Next location: ");
		String newPlace = In.readWord();
		current = trafficNetwork.getLocation(newPlace);
		System.out.println();
		} while(!current.equals(init));
		
		System.out.println("You are back in " + init.getName());
		System.out.println("====================================================");
	}

}
