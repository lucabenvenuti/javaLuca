package figures.test;

import figures.Figure;
import figures.Rectangle;
import animation.Controller;

/**
 * Exercise3.java
 *
 * A {@link Exercise3} is a class 
 * that tests the third assignment
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Exercise3 {
	public static void main(String[] args) {
		Figure r = new Rectangle(20,20,10,10);
		Controller.addFigure(r);
		Controller.addAnimation(r.createXAnimation());
		Controller.addAnimation(r.createYAnimation());
		
		Controller.display();
	}
}
