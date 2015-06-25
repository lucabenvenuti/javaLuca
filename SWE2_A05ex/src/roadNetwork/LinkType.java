package roadNetwork;

import java.awt.Color;

/**
 * LinkType.java
 *
 * A {@link LinkType} is an enum for roads, provides speed and, by a dedicated
 * method, the color on the map
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public enum LinkType {

	AUTOBAHN(130), BUNDESSTRASSE(100), STRASSE(50);

	private int vel;

	private LinkType(int vel) {
		this.vel = vel;
	}

	public int getVel() {
		return vel;
	}

	Color getColor() {
		if (this == AUTOBAHN) {
			return Color.GREEN;
		}

		if (this == BUNDESSTRASSE) {
			return Color.RED;
		}

		if (this == STRASSE) {
			return Color.BLACK;
		}

		return Color.YELLOW;
	}

}
