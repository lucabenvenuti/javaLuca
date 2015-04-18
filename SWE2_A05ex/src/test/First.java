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

		/*
		 * // Link.lengthOrder.compare(o1, o2); //the treemap sorts by key
		 * TreeMap<String, String> hm = new TreeMap<String, String>(new
		 * MyComp()); //add key-value pair to TreeMap hm.put("java",
		 * "language"); hm.put("computer", "machine");
		 * hm.put("india","country"); hm.put("mango","fruit");
		 * System.out.println(hm);
		 */

		SortedMap<String, Location> hm2 = new TreeMap<String, Location>();
		hm2.put("Linz", new Location(300, 80, "Linz"));
		hm2.put("Wels", new Location(240, 90, "Wels"));
		hm2.put("Satt", new Location(230, 110, "Satt"));
		System.out.println(hm2);

		TrafficNetwork trafficNetwork = new TrafficNetwork();
		trafficNetwork.addLocation(new Location(300, 80, "Linz"));
		trafficNetwork.addLocation(new Location(240, 90, "Wels"));
		trafficNetwork.addLocation(new Location(230, 110, "Satt"));
		System.out.println(trafficNetwork.getNetworkMap());

	}

}

class MyComp implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		return str1.compareTo(str2);
	}

}

/*
 * class MyComp2 implements Comparator<Location>{
 * 
 * @Override public int compare(Location loc1, Location loc2) { return
 * loc1.getName().compareTo(loc2.getName()); }
 * 
 * }
 */