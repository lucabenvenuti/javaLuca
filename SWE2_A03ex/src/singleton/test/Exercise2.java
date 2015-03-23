package singleton.test;

import figures.CompoundFigure;
import figures.Figure;
import figures.Rectangle;
import animation.Controller;

public class Exercise2 {
	public static void main(String[] args) {
		Figure r = new Rectangle(20,20,10,10);
		CompoundFigure compoundFigure = new CompoundFigure(20,20);
		
		for(int i=0;i<15;i++){
			compoundFigure.add(r);
		}
		
		Controller.addFigure(compoundFigure);
		
		Controller.display();
	}
}
