package figures.test;

import figures.CompoundFigure;
import figures.Rectangle;
import animation.Controller;

/**
 * Exercise2.java
 *
 * A {@link Exercise2} is a class 
 * that tests the second assignment
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Exercise2 {
	public static void main(String[] args) {
		CompoundFigure compoundFigure = new CompoundFigure(20,20);
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 3; j++){
				compoundFigure.add(new Rectangle(j*15, i*30, 10, 10));
			}
		}
		
		Controller.addFigure(compoundFigure);
		
		Controller.display();
	}
}
