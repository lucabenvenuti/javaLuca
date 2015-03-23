package figures.test;

import figures.CompoundFigure;
import figures.Figure;
import figures.Rectangle;
import animation.Controller;

public class Exercise2 {
	public static void main(String[] args) {
		Figure r = new Rectangle(20,20,10,10);
		CompoundFigure compoundFigure = new CompoundFigure(20,20);
		
//		if (k==5 || k ==10){i=0;}
//		if (k>9){j=5;}
//		else if (k>4){j=10;}
//		f.draw(xOrigin+15*j, yOrigin+i);
//		i = i +20;
//		k++;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 3; j++){
				compoundFigure.add(new Rectangle(j*15, i*30, 10, 10));
			}
		}
//			compoundFigure.add(new Rectangle(0, 0, 10, 10));
//			compoundFigure.add(new Rectangle(0, 40, 10, 10));
//			compoundFigure.add(new Rectangle(0, 60, 10, 10));
//			compoundFigure.add(new Rectangle(0, 80, 10, 10));
//			compoundFigure.add(new Rectangle(0, 100, 10, 10));
//
//			compoundFigure.add(new Rectangle(15, 0, 10, 10));
//			compoundFigure.add(new Rectangle(15, 40, 10, 10));
//			compoundFigure.add(new Rectangle(15, 60, 10, 10));
//			compoundFigure.add(new Rectangle(15, 80, 10, 10));
//			compoundFigure.add(new Rectangle(15, 100, 10, 10));

			//		}
		
		Controller.addFigure(compoundFigure);
		
		Controller.display();
	}
}
