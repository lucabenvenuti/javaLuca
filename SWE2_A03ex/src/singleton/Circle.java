package singleton;

import inout.Window;



public class Circle extends Figure{

	private int r;

	
/*	protected Circle(int x, int y, int w, int h) {
		super(x, y, w, h);
		if ((w)!=(h))
		throw new IllegalArgumentException("Not a circle");		
	}*/
	
	public Circle(int x, int y, int r) {
		super(x, y);
		this.r=r;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {

		Window.drawCircle(xOrigin+x, yOrigin+y, r); //int x, int y, int w, int h
		
	}



}


//super(x, y);

//	super(x, x);