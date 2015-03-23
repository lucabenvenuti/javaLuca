package singleton.test;

import singleton.Circle;
import singleton.CompoundFigure;
import singleton.Rectangle;
import singleton.Figure;
import singleton.Line;
import animation.Animation;
import animation.Controller;

public class SingletonTest {

	public static void main(String[] args) {
		
		Figure circle = new Circle(20,20,50);
		
		circle.draw(40, 70);
		
		Figure rectangle = new Rectangle(20,20,50,80);
		
		rectangle.draw(140, 170);
		
		Figure line = new Line(20,20,50,80);
		
		line.draw(140, 170);
		
		CompoundFigure compoundFigure = new CompoundFigure(20,20,20,20);
		
	//	compoundFigure.add(circle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		compoundFigure.add(rectangle);
		
	//	compoundFigure.draw(20, 20);
		
		Controller.addFigure(circle);
		Controller.addFigure(rectangle);
		
	
}
}