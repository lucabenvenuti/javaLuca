
class TwoDMovie extends AbstractMovie {
	


	public TwoDMovie(Screen[] screens, String screeningTime, int length,
			String name) {
		super(screens, screeningTime, length, name);
		// TODO Auto-generated constructor stub
	}

	public TwoDMovie(Screen[] screens, String screeningTime, int length) {
		super(screens, screeningTime, length);
		// TODO Auto-generated constructor stub
	}

	public TwoDMovie(Screen[] screens) {
		super(screens);
		// TODO Auto-generated constructor stub
	}

	public String getQualifier(){
		return "[2D]";
	}

	//price surcharge is 0 € (standard movie is 2D); nothing to do
}
