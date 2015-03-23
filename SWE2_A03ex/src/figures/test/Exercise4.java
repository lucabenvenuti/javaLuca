package figures.test;

import figures.Circle;
import figures.CompoundFigure;
import figures.Figure;
import figures.Rectangle;
import animation.Controller;

public class Exercise4 {
	public static void main(String[] args) {
		Figure r = new Rectangle(200,200,10,10);
//		Figure c = new Circle((int) (200+100*Math.sqrt(2)/2), (int) (200+100*Math.sqrt(2)/2), 10);
		Figure c = new Circle(600, 600, 10);

	//	Controller.addFigure(c);
	//	Controller.addFigure(r);
	//	Controller.addAnimation(r.createCircleAnimation(100,100));
	//	
		CompoundFigure compoundFigure = new CompoundFigure(20,20);
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 3; j++){
				compoundFigure.add(new Rectangle(j*15, i*30, 10, 10));
			}
		}
		
		Controller.addFigure(compoundFigure);
		Controller.addAnimation(compoundFigure.createCircleAnimation(100,100));
		
		Controller.display();
	}
}
