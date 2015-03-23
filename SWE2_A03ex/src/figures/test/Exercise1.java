package figures.test;

import figures.Circle;
import figures.Figure;
import figures.Line;
import figures.Rectangle;
import animation.Controller;

public class Exercise1 {
	public static void main(String[] args) {
		Circle c = new Circle(50, 50, 10);
		Figure r = new Rectangle(120,20,50,80);
		
		Figure l = new Line(220,20,50,80);
		
		Controller.addFigure(c);
		Controller.addFigure(r);
		Controller.addFigure(l);
		
		Controller.display();

//		Figure[] figures = new Figure[] {
//					new Circle(50, 50, 10),
//					new Rectangle(120,20,50,80),
//					new Line(220,20,50,80)
//				};
//
//		for (Figure f : figures) {
//			Controller.addFigure(f);
//		}
//		Controller.display();
	}
}
