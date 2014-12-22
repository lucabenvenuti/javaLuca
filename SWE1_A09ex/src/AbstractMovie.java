
abstract class AbstractMovie implements Movie {
//class Circle implements GeometricFigure
	
	//Cinema.NOFSCREENS
	
	//abstract method getQualifier from superclass
	
	Screen[] screens = new Screen[Cinema.NOFSCREENS];
	private int length;
	private int priceSurcharge;
	private String name;
	private String screeningTime;
	
	public AbstractMovie(Screen[] screens){
		setScreens(screens);
		
	}
	
	public AbstractMovie(Screen[] screens, int length){
		this(screens);
		setLength(length);
	//	setScreeningTime(screeningTime);String screeningTime, String screeningTime, screeningTime, 
		setPriceSurcharge();
	}
	
	public AbstractMovie(Screen[] screens, int length, String name){
		this(screens, length);
		setName(name);
	}
	
	public AbstractMovie(Screen[] screens, int length, String name, String screeningTime){
		this(screens, length, name);
		setScreeningTime(screeningTime);
	}
	
	public int priceSurcharge(){
		if (length()>120){
			return 1;
		}else {return 0;}
		
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

	public void setPriceSurcharge() {
		this.priceSurcharge = priceSurcharge();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreeningTime() {
		return screeningTime;
	}

	public void setScreeningTime(String screeningTime) {
		this.screeningTime = screeningTime;
	}
	
}
