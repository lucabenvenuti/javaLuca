package singleton;

import inout.Window;



public class Circle extends Figure{

	public Circle(int x, int y) {
		super(x, y);
		if ((x)!=(y))
			throw new IllegalArgumentException("Op not supported: ");		
		// TODO Auto-generated constructor stub
	}

	public Circle(int x) {
		super(x, x);
		
	}
	
	@Override
	public void draw(int xOrigin, int yOrigin) {

		Window.drawCircle(xOrigin+x/2, yOrigin+x/2, x/2); //int x, int y, int w, int h
		
	}



}
