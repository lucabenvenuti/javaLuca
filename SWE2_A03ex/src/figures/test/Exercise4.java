package figures.test;

import figures.Figure;
import figures.Rectangle;
import animation.Controller;

public class Exercise4 {
	public static void main(String[] args) {
		Figure r = new Rectangle(200,200,10,10);
		Controller.addFigure(r);
		Controller.addAnimation(r.createCircleAnimation(100,100));
		
		Controller.display();
	}
}
