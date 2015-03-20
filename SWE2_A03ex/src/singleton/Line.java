package singleton;

import inout.Window;



public class Line extends Figure{

	public Line(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawLine(xOrigin, yOrigin, x+xOrigin , y+yOrigin); //int x, int y, int w, int h
		
	}



}
