package figures;

import inout.Window;

public class Line extends Figure{

	private int w;
	private int h;

	public Line(int x, int y, int w, int h) {
		super(x, y);
		this.w = w;
		this.h =h;
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawLine(xOrigin+x, yOrigin+y, x+xOrigin+w , y+yOrigin+h);
	}
}
