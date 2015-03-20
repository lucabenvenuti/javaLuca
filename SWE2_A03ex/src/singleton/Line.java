package singleton;

import inout.Window;



class Line extends Figure{

	protected Line(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawLine(xOrigin, yOrigin, x , y); //int x, int y, int w, int h
		
	}



}
