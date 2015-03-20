package singleton.test;

import singleton.Circle;
import singleton.Rectangle;
import singleton.Figure;
import animation.Animation;
import animation.Controller;

public class SingletonTest {

	public static void main(String[] args) {
		
		Figure circle = new Circle(50);
		
		circle.draw(40, 70);
		
		Figure rectangle = new Rectangle(50,80);
		
		rectangle.draw(140, 170);
		
		Controller.addFigure(circle);
		Controller.addFigure(rectangle);
		
	
}
}