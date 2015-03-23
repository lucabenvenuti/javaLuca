package singleton.test;

import figures.CompoundFigure;
import figures.Figure;
import figures.Rectangle;
import animation.Controller;

public class Exercise3 {
	public static void main(String[] args) {
		Figure r = new Rectangle(20,20,10,10);
		Controller.addFigure(r);
		Controller.addAnimation(r.createXAnimation());
		Controller.addAnimation(r.createYAnimation());
		
		Controller.display();
	}
}
