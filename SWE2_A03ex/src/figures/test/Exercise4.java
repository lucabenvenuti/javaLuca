package figures.test;

import figures.Circle;
import figures.Figure;
import figures.Rectangle;
import animation.Controller;

/**
 * Exercise4.java
 *
 * A {@link Exercise4} is a class 
 * that tests the fourth assignment
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Exercise4 {
	public static void main(String[] args) {
		Figure r = new Rectangle(200,200,10,10);
		Figure c = new Circle(200, 200, 10);

		Controller.addFigure(c);
		Controller.addFigure(r);
		Controller.addAnimation(r.createCircleAnimation(100,100));
		
		Controller.display();
	}
}
