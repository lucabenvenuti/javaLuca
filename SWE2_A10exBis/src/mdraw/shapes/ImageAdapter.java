package mdraw.shapes;

import static mdraw.shapes.ShapeUtil.areClose;
import static mdraw.shapes.ShapeUtil.isWithin;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import mdraw.visitor.ShapeVisitor;

/**
 * ImageAdapter.
 * 
 * @author Luca Benvenuti
 * @version 1.0
 */
public class ImageAdapter extends PrimitiveShape  {

	/** x-coordinate of the shape. */
	protected int x;

	/** y-coordinate of the shape. */
	protected int y;

	/** Width of the shape. */
	private int w;

	/** Height of the shape. */
	private int h;

	private Image image;

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
	public ImageAdapter(Image image, int x, int y, int w, int h) {
		super(x, y, w, h);
		this.image = image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
		this.x = x;
		this.y = y;
    }

	@Override
	public void setSize(int w, int h) {
		super.setSize(w, h);
		image = image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
	}

	public void paint(Graphics g) {
		g.drawImage(image, getLeft(), getTop(), Color.WHITE, null);
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#draw()
	 */
	@Override
	public void draw(Graphics g) {
		paint(g);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see shapes.Shape#draw()
	 */
	@Override
	public void fill(Graphics g, Color c) {
		paint(g);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see draw.shapes.Shape#isSelection(int, int)
	 */
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