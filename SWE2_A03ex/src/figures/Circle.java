package figures;

import inout.Window;

public class Circle extends Figure{

	private int r;
	
	public Circle(int x, int y, int r) {
		super(x, y);
		this.r=r;
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawCircle(xOrigin+x, yOrigin+y, r); 
	}
}