package figures;

import inout.Window;

/**
 * Line.java
 *
 * A {@link Line} is a class which extends Figure
 * and implements a draw method of a line
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class Line extends Figure{

	private int w;
	private int h;

	/**
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * a line is represented as figure that is the diagonal of a rectangle,
	 * hence it has a width and an height
	 */
	public Line(int x, int y, int w, int h) {
		super(x, y);
		this.w = w;
		this.h =h;
	}

	/** (non-Javadoc)
	 * @see figures.Figure#draw(int, int)
	 * draw a line
	 */
	@Override
	public void draw(int xOrigin, int yOrigin) {
		Window.drawLine(xOrigin+x, yOrigin+y, x+xOrigin+w , y+yOrigin+h);
	}
}
