/**
 * ThreeDMovie.java
 *
 * A {@link ThreeDMovie} is a class which extends a
 * {@link AbstractMovie} class, storing a qualifier 
 * and a price increase, together with some chained constructors
 * (no further implementations is strictly necessary)
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-26
 */
class ThreeDMovie extends AbstractMovie {
	
	/**
	 * @param screens
	 * @param length
	 * @param name
	 * Auto-generated constructor stub
	 */
	public ThreeDMovie(Screen[] screens, int length, String name) {
		super(screens, length, name);
	}

	/**
	 * @param screens
	 * @param length
	 * Auto-generated constructor stub
	 */
	public ThreeDMovie(Screen[] screens, int length) {
		super(screens, length);
	}

	/**
	 * @see Movie#getQualifier()
	 * @return a String with the Qualifier of a movie
	 */
	public String getQualifier(){
		return "[3D]";
	}

	/**
	 * @param screens
	 * Auto-generated constructor stub
	 */
	public ThreeDMovie(Screen[] screens) {
		super(screens);
	}
	
	/**
	 * @see Movie#priceSurcharge()
	 * @return 
	 * 			price increase
	 */
	public int priceSurcharge(){
		return super.priceSurcharge() + 1;
	}
}
