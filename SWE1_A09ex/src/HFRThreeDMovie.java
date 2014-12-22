
class HFRThreeDMovie extends ThreeDMovie{
	

	public HFRThreeDMovie(Screen[] screens, String screeningTime, int length,
			String name) {
		super(screens, screeningTime, length, name);
		// TODO Auto-generated constructor stub
	}
	public HFRThreeDMovie(Screen[] screens, String screeningTime, int length) {
		super(screens, screeningTime, length);
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
