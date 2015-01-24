//package at.jku.pervasive.swe14.UE12.numberList;

class NumberNode {
	private int num;
	public NumberNode next; // next node in list

	public NumberNode(int num) { // constructor
		this.num = num;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
}