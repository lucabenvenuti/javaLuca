/**
 * TwoDMovie.java
 *
 * A {@link TwoDMovie} is a class which extends a
 * {@link AbstractMovie} class, storing a qualifier 
 * and a price increase, together with some chained constructors
 * (no further implementations is necessary)
 * price surcharge is 0 € (standard movie is 2D); 
 * no implementation of priceSurcharge()
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-26
 */
class TwoDMovie extends AbstractMovie {

	/**
	 * @param screens
	 * @param length
	 * @param name
	 * Auto-generated constructor stub
	 */
	public TwoDMovie(Screen[] screens, int length, String name) {
		super(screens, length, name);
	}

	/**
	 * @param screens
	 * @param length
	 * Auto-generated constructor stub
	 */
	public TwoDMovie(Screen[] screens, int length) {
		super(screens, length);
	}

	/**
	 * @param screens
	 * Auto-generated constructor stub
	 */
	public TwoDMovie(Screen[] screens) {
		super(screens);
	}

	/**
	 * @see Movie#getQualifier()
	 * @return a String with the Qualifier of a movie
	 */
	public String getQualifier(){
		return "[2D]";
	}
}
