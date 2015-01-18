/* Date.java
 * Software Development 1.07 Objects III
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-11-11 Michael Matscheko */

//package at.jku.pervasive.swe1.vo7;

public class Date {
	public int year, month, day;

	public Date() { // default constructor: 1. 1. 1970
		this.year = 1970;
		this.month = 1;
		this.day = 1;
	}
	
	public Date(int day, int month, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String toString() {
		return year + "-" + month + "-" + day;
	}
}
