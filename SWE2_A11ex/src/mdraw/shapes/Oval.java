package mdraw.shapes;

import java.awt.Color;
import java.awt.Graphics;
import mdraw.visitor.*;

/**
 * Class for oval shape objects.
 * 
 * @author Herbert Praehofer & Luca Benvenuti
 * @version 1.2
 * @since 1.1
 */
public class Oval extends PrimitiveShape {

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
	public Oval(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override  // Javadoc: see super class
	public void draw(Graphics g) {
		g.drawOval(getLeft(), getTop(), getWidth(), getHeight());
	}

	@Override  // Javadoc: see super class
	public void fill(Graphics g, Color c) {
		Color prev = g.getColor();
		g.setColor(c);
		g.fillOval(getLeft(), getTop(), getWidth(), getHeight());
		g.setColor(prev);
	}

	@Override  // Javadoc: see super class
	public boolean isSelection(int x, int y) {
		// based on ellipse equation b2*x2 + a2*y2 = a2*b2
		double a = (double) getWidth() / 2;
		double b = (double) getHeight() / 2;
		double xE = x - getLeft() - a;
		double yE = y - getTop() - b;
		double a2b2 = a * a * b * b;
		double d2 = b * b * xE * xE + a * a * yE * yE;
		double d2S = Math.pow(d2, 0.25);
		double a2b2S = Math.pow(a2b2, 0.25);
		return ShapeUtil.areClose(d2S, a2b2S);
	}
	
	@Override  // Javadoc: see super class
	public <T> T accept(ShapeVisitor<T> v) {
		return v.visitOval(this);
	}

}
