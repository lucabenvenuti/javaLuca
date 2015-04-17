package roadNetwork;

public enum LinkType {
	
	//CS(521), WiWi(180), Mechatronics(281), IE(289); 
	AUTOBAHN(130), BUNDESSTRASSE(100), STRASSE(50);
	
	private int vel;

	private LinkType(int vel) {
		this. vel = vel;
	}

	public int getVel () {
		return vel;
	}

	@Override
	public String toString() {
		return super.toString() + "(" + vel + ")";
	} 

}
