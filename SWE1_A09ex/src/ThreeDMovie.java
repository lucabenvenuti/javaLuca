
class ThreeDMovie extends AbstractMovie {
	
	public ThreeDMovie(Screen[] screens, String screeningTime, int length,
			String name) {
		super(screens, screeningTime, length, name);
		// TODO Auto-generated constructor stub
	}



	public ThreeDMovie(Screen[] screens, String screeningTime, int length) {
		super(screens, screeningTime, length);
		// TODO Auto-generated constructor stub
	}



	public String getQualifier(){
		return "[3D]";
	}



	public ThreeDMovie(Screen[] screens) {
		super(screens);
		// TODO Auto-generated constructor stub
	}

	public int priceSurcharge(){
		return super.priceSurcharge() + 1;
	}
}
