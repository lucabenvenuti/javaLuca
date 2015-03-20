package singleton;

import inout.Window;



public class Rectangle extends Figure{

	public Rectangle(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawRectangle(xOrigin, yOrigin, x , y); //int x, int y, int w, int h
		
	}



}
