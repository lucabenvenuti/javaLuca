
class HFRThreeDMovie extends ThreeDMovie{
	


	public HFRThreeDMovie(Screen[] screens, int length, String name) {
		super(screens, length, name);
		// TODO Auto-generated constructor stub
	}
	public HFRThreeDMovie(Screen[] screens, int length) {
		super(screens, length);
		// TODO Auto-generated constructor stub
	}
	public HFRThreeDMovie(Screen[] screens) {
		super(screens);
		// TODO Auto-generated constructor stub
	}
	public String getQualifier(){
		return "[3D, HFR]";
	}
	public int priceSurcharge(){
		return super.priceSurcharge() + 1;
	}
}
