
class SpecialMovie implements Movie {

	Screen[] screens = new Screen[Cinema.NOFSCREENS];
	private int length;
	private int priceSurcharge;
	private String name;
	private String screeningTime;
	
	public SpecialMovie(Screen[] screens){
		setScreens(screens);
		
	}
	
	//public Screen(Screen screen, Movie movie, String screeningTime);
	
	public SpecialMovie(Screen[] screens, String screeningTime, int priceSurcharge){
		this(screens);
		setScreeningTime(screeningTime);
		//setLength(length);
		setPriceSurcharge(priceSurcharge);
	}
	
/*	public SpecialMovie(Screen[] screens, int length, String name){
		this(screens, length);
		setName(name);
	}*/
	
	public SpecialMovie(Screen[] screens, String screeningTime, int length, String name, int priceSurcharge){
		this(screens, screeningTime, priceSurcharge);
		setLength(length);
		setName(name);
	}
	
	public int priceSurcharge(){
	/*	if (length()>120){
			return 1;
		}else {return 0;}*/
		return priceSurcharge;
	}
	
	
	public String getName(){
		return name;
	}
	
	public int length(){
		return length;
	}


	public void setScreens(Screen[] screens){
		this.screens=screens;
	}
	public Screen[] getScreens(){
		return screens;
	}


	public void setLength(int length) {
		this.length = length;
	}

	public int getPriceSurcharge() {
		return priceSurcharge;
	}

	public void setPriceSurcharge(int priceSurcharge) {
		this.priceSurcharge = priceSurcharge;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getQualifier(){
		return "[SS]";
	}

	public String getScreeningTime() {
		return screeningTime;
	}

	public void setScreeningTime(String screeningTime) {
		this.screeningTime = screeningTime;
	}
	
}
