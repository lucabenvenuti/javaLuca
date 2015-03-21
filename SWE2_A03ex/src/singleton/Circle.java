package singleton;

import inout.Window;



public class Circle extends Figure{


	
	protected Circle(int x, int y, int w, int h) {
		super(x, y, w, h);
		if ((w)!=(h))
		throw new IllegalArgumentException("Not a circle");		
	}
	
	public Circle(int x, int y, int w) {
		super(x, y, w, w);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {

		Window.drawCircle(xOrigin+x, yOrigin+y, w/2); //int x, int y, int w, int h
		
	}



}


//super(x, y);

//	super(x, x);