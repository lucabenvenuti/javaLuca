/**
 * HFRThreeDMovie.java
 *
 * A {@link HFRThreeDMovie} is a class that extends a 
 * {@link ThreeDMovie} class with different qualifiers 
 * and price increase
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-26
 */
class HFRThreeDMovie extends ThreeDMovie{

	/**
	 * @param screens
	 * @param length
	 * @param name
	 * Auto-generated constructor stub
	 */
	public HFRThreeDMovie(Screen[] screens, int length, String name) {
		super(screens, length, name);
		setName("troa");
	}
	/**
	 * @param screens
	 * @param length
	 * Auto-generated constructor stub
	 */
	public HFRThreeDMovie(Screen[] screens, int length) {
		super(screens, length);
	}
	/**
	 * @param screens
	 * Auto-generated constructor stub
	 */
	public HFRThreeDMovie(Screen[] screens) {
		super(screens);
	}

	/**
	 * @see ThreeDMovie#getQualifier()
	 * String getQualifier of a movie
	 */
	public String getQualifier(){
		return "[3D, HFR]";
	}

	/**
	 * @see ThreeDMovie#priceSurcharge()
	 * return the updated priceSurcharge
	 */
	public int priceSurcharge(){
		return super.priceSurcharge() + 1;
	}
}
