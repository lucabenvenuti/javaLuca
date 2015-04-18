package roadNetwork;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TrafficNetwork {

	SortedMap<String, Location> networkMap = new TreeMap<String, Location>();
	
	

}

/*
 * Comparator<Link> lengthOrder = new Comparator<Link>() {
 * 
 * @Override public int compare(Link s1, Link s2) { return s1.getLength() -
 * s2.getLength(); } };
 * 
 * //SortedMap<Location, String> sortedMap; //SortedMap<Location, String> mapA =
 * new TreeMap<Location, String>(lengthOrder);
 */
