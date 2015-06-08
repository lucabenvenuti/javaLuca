package mdraw.shapes;

import static mdraw.shapes.ShapeUtil.areClose;
import static mdraw.shapes.ShapeUtil.isWithin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import mdraw.visitor.ShapeVisitor;


/**
 * ImageAdapter.java
 *
 * A {@link ImageAdapter} is a public class implementing a {@link PrimitiveShape}. It
 * adapts an {@link Image} to a Shape.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class ImageAdapter extends PrimitiveShape {

	private Image image;

	/**
	 * Constructor initializing image and x and y coordinate and width and
	 * heigth.
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
	public ImageAdapter(Image image, int x, int y, int w, int h) {
		super(x, y, w, h);
		this.image = image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
	}

	@Override
	public void setSize(int w, int h) {
		super.setSize(w, h);
		image = image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
	}

	@Override
	public void draw(Graphics g) {
		fill(g, Color.WHITE);
	}

	@Override
	public void fill(Graphics g, Color c) {
		g.drawImage(image, getLeft(), getTop(), Color.WHITE, null);
	}

	@Override
	public boolean isSelection(int x, int y) {
		return ((areClose(x, getLeft()) || areClose(x, getLeft() + getWidth())) && isWithin(
				y, getTop(), getTop() + getHeight()))
				|| ((areClose(y, getTop()) || areClose(y, getTop()
						+ getHeight())) && isWithin(x, getLeft(), getLeft()
						+ getWidth()));
	}

	@Override
	public <T> T accept(ShapeVisitor<T> v) {
		return v.visitAdapter(this);
	}

}