package singleton;

import inout.Window;



public class Rectangle extends Figure{



	public Rectangle(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawRectangle(xOrigin+x, yOrigin+y, w , h); //int x, int y, int w, int h
		
	}



}
