package persons5;

public enum Study {
	
	CS(521), WiWi(180), Mechatronics(281), IE(289); 
	
	private int currId;

	private Study(int currId) {
		this. currId = currId;
	}

	public int getCurrId () {
		return currId;
	}

	@Override
	public String toString() {
		return super.toString() + "(" + currId + ")";
	} 

}
