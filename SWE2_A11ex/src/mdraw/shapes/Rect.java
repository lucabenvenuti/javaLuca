package mdraw.shapes;

import static mdraw.shapes.ShapeUtil.areClose;
import static mdraw.shapes.ShapeUtil.isWithin;
import mdraw.visitor.*;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Class representing rectangular shapes.
 * 
 * @author Herbert Praehofer & Luca Benvenuti
 * @version 1.2
 * @since 1.1
 */
public class Rect extends PrimitiveShape {

	/**
	 * Constructor initializing x and y coordinate and width and heigth.
	 * 
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 * @param w
	 *            the width
	 * @param h
	 *            the height
	 */
	public Rect(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override  // Javadoc: see super class
	public void draw(Graphics g) {
		g.drawRect(getLeft(), getTop(), getWidth(), getHeight());
	}

	@Override  // Javadoc: see super class
	public void fill(Graphics g, Color c) {
		Color prev = g.getColor();
		g.setColor(c);
		g.fillRect(getLeft(), getTop(), getWidth(), getHeight());
		g.setColor(prev);
	}

	@Override  // Javadoc: see super class
	public boolean isSelection(int x, int y) {
		return ((areClose(x, getLeft()) || areClose(x, getLeft() + getWidth())) && isWithin(
				y, getTop(), getTop() + getHeight()))
				|| ((areClose(y, getTop()) || areClose(y, getTop()
						+ getHeight())) && isWithin(x, getLeft(), getLeft()
						+ getWidth()));
	}

	@Override  // Javadoc: see super class
	public <T> T accept(ShapeVisitor<T> v) {
		return v.visitRect(this);
	}

}
