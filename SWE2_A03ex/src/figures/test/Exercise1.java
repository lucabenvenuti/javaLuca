package figures.test;

import figures.Circle;
import figures.Figure;
import figures.Line;
import figures.Rectangle;
import animation.Controller;

/**
 * Exercise1.java
 *
 * A {@link Exercise1} is a class 
 * that tests the first assignment
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Exercise1 {
	public static void main(String[] args) {
		Circle c = new Circle(50, 50, 10);
		Figure r = new Rectangle(120,20,50,80);
		
		Figure l = new Line(220,20,50,80);
		
		Controller.addFigure(c);
		Controller.addFigure(r);
		Controller.addFigure(l);
		
		Controller.display();
	}
}
