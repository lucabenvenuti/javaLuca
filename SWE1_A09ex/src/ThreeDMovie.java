
class ThreeDMovie extends AbstractMovie {
	
	public String getQualifier(){
		return "[3D]";
	}

	public ThreeDMovie(Screen[] screens, int length, String name) {
		super(screens, length, name);
		// TODO Auto-generated constructor stub
	}

	public ThreeDMovie(Screen[] screens, int length) {
		super(screens, length);
		// TODO Auto-generated constructor stub
	}

	public ThreeDMovie(Screen[] screens) {
		super(screens);
		// TODO Auto-generated constructor stub
	}

	public int priceSurcharge(){
		return super.priceSurcharge() + 1;
	}
}
