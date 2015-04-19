package roadNetwork;

import java.awt.Color;

public enum LinkType {

	AUTOBAHN(130), BUNDESSTRASSE(100), STRASSE(50);

	private int vel;

	private LinkType(int vel) {
		this.vel = vel;
	}

	public int getVel() {
		return vel;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public Color getColor() {
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
