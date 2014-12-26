/**
 * AbstractMovie.java
 *
 * A {@link AbstractMovie} is a class which implements a
 * {@link Movie} class, storing length, priceSurcharge and
 * name, together with some chained constructors
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-26
 */
abstract class AbstractMovie implements Movie {
	
	Screen[] screens = new Screen[Cinema.NOFSCREENS];
	private int length;
	private int priceSurcharge;
	private String name;
	
	/**
	 * @param screens
	 * Constructor to give screens to a movie
	 */
	public AbstractMovie(Screen[] screens){
		setScreens(screens);
	}
	
	/**
	 * @param screens
	 * @param length
	 * Constructor to give screens and length to a movie
	 */
	public AbstractMovie(Screen[] screens, int length){
		this(screens);
		setLength(length); 
		setPriceSurcharge();
	}
	
	/**
	 * @param screens
	 * @param length
	 * @param name
	 * Constructor to give screens and length and a name to a movie
	 */
	public AbstractMovie(Screen[] screens, int length, String name){
		this(screens, length);
		setName(name);
	}

	/**
	 * @see Movie#priceSurcharge()
	 * generic implementation
	 */
	public int priceSurcharge(){
		if (length()>120){
			return 1;
		}else {return 0;}	
	}
	
	/**
	 * @see Movie#getName()
	 * @return String name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @see Movie#length()
	 * @return int length
	 */
	public int length(){
		return length;
	}

	/**
	 * @see Movie#setScreens(Screen[])
	 * @param screens
	 */
	public void setScreens(Screen[] screens){
		this.screens=screens;
	}
	
	/**
	 * @see Movie#getScreens()
	 * @return screens
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
	 * call priceSurcharge()
	 */
	public void setPriceSurcharge() {
		this.priceSurcharge = priceSurcharge();
	}

	/**
	 * @see Movie#setName(java.lang.String)
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
