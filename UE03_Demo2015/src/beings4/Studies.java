package beings4;

public enum Studies {
	
	CS(521), WiWi(180), Mechatronics(281), IE(289); 
	
	private int skz;

	private Studies(int skz) {
		this.skz = skz;
	}

	public int getSkz() {
		return skz;
	}

	@Override
	public String toString() {
		return super.toString() + "(" + skz + ")";
	} 

}
