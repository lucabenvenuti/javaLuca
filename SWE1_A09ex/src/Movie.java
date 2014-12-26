/**
 * Movie.java
 *
 * A {@link Movie} is a class that extends a create 
 * and interface for any movies
 * 
 * Software Development I, 2014WS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @version 2014-12-26
 */
interface Movie {
	String getName();
	void setName(String name);
	int length();
	int priceSurcharge();
	String getQualifier();
	void setScreens(Screen[] screens);
	Screen[] getScreens();
}
