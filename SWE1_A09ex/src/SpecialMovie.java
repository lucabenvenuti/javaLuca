/**
 * SpecialMovie.java
 *
 * A {@link SpecialMovie} is a class which implements a
 * {@link Movie} class, storing length, priceSurcharge and
 * name, together with some chained constructors
 * (no further implementation is necessary)
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-26
 */
class SpecialMovie implements Movie {

	Screen[] screens = new Screen[Cinema.NOFSCREENS];
	private int length;
	private int priceSurcharge;
	private String name;
	
	/**
	 * @param screens
	 * simple constructor
	 */
	public SpecialMovie(Screen[] screens){
		setScreens(screens);
	}
	
	/**
	 * @param screens
	 * @param priceSurcharge
	 * chained constructor
	 */
	public SpecialMovie(Screen[] screens, int priceSurcharge){
		this(screens);
		setPriceSurcharge(priceSurcharge);
	}

	/**
	 * @param screens
	 * @param priceSurcharge
	 * @param length
	 * @param name
	 * second chained constructor with all the necessary parameters
	 */
	public SpecialMovie(Screen[] screens, int priceSurcharge, int length, String name){
		this(screens, priceSurcharge);
		setLength(length);
		setName(name);
	}
	
	/**
	 * @see Movie#priceSurcharge()
	 * @return 
	 * 			price increase
	 */
	public int priceSurcharge(){
		return priceSurcharge;
	}
	
	
	/**
	 * @see Movie#getName()
	 * @return the name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @see Movie#length()
	 * @return the length in minutes
	 */
	public int length(){
		return length;
	}


	/**
	 * @see Movie#setScreens(Screen[])
	 * @param Screen[] screens
	 */
	public void setScreens(Screen[] screens){
		this.screens=screens;
	}
	/**
	 * @see Movie#getScreens()
	 * @return a Screen array
	 */
	public Screen[] getScreens(){
		return screens;
	}

	/**
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return
	 */
	public int getPriceSurcharge() {
		return priceSurcharge;
	}

	/**
	 * @param priceSurcharge
	 */
	public void setPriceSurcharge(int priceSurcharge) {
		this.priceSurcharge = priceSurcharge;
	}

	/**
	 * @see Movie#setName(java.lang.String)
	 * @param a String with the movie name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @see Movie#getQualifier()
	 * @return a String with the Qualifier of a movie
	 */
	public String getQualifier(){
		return "[SS]";
	}
}
