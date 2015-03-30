package figures;

import inout.Out;
import inout.Window;

/**
 * Circle.java
 *
 * A {@link Circle} is a class which extends Figure
 * and implements a draw method of a circle
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Circle extends Figure{

	private int r;
	
	/**
	 * @param x
	 * @param y
	 * @param r
	 * a figure with a radius
	 */
	public Circle(int x, int y, int r) {
		super(x, y);
		this.r=r;
	}

	/** (non-Javadoc)
	 * @see figures.Figure#draw(int, int)
	 * draw a figure with a radius ==> a circle
	 * print the required console output
	 */
	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawCircle(xOrigin+x, yOrigin+y, r); 
		Out.println(" -> displayCircle: received " + toString());
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
}