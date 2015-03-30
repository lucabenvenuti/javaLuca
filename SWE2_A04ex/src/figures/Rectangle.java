package figures;

import inout.Out;
import inout.Window;

/**
 * Rectangle.java
 *
 * A {@link Rectangle} is a class which extends Figure
 * and implements a draw method of a rectangle
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Rectangle extends Figure{

	private int w;
	private int h;
	
	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * a rectangle is a figure with a width and an height
	 */
	public Rectangle(int x, int y, int w, int h) {
		super(x, y);
		this.w = w;
		this.h =h;
	}

	/** (non-Javadoc)
	 * @see figures.Figure#draw(int, int)
	 * draw a rectangle
	 */
	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawRectangle(xOrigin+x, yOrigin+y, w , h); 	
		Out.println(" -> displayRectangle: received " + toString());
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rect [x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + "]";
	}
	

}
