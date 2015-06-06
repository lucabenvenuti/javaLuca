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

/**
 * ImageAdapter.
 * 
 * @author Luca Benvenuti
 * @version 1.0
 */
public class ImageAdapter extends Applet implements Shape  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** x-coordinate of the shape. */
	protected int x;

	/** y-coordinate of the shape. */
	protected int y;

	/** Width of the shape. */
	private int w;

	/** Height of the shape. */
	private int h;

	private Image image;
	private boolean loaded = false;

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
	public ImageAdapter(int x, int y) {
		this.x = x;
		this.y = y;
		init();
	}
	
	public void init() {
		int h1 = 0;
		int w1 = 0;
		JFileChooser chooser = new JFileChooser(".");
		int code = chooser.showOpenDialog(null);
		if (code == 0) {
			File imgFile = chooser.getSelectedFile();
			try {
				image = javax.imageio.ImageIO.read(imgFile);
				h1 = image.getHeight(chooser);
				w1 = image.getWidth(chooser);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		h = h1;
		w = w1;
		prepareImage(image, -1, -1, this);
	}

	public void paint(Graphics g) {
		if (loaded)
			g.drawImage(image, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public synchronized boolean imageUpdate(Image image, int infoFlags, int x,
			int y, int width, int height) {
		if ((infoFlags & ImageObserver.ALLBITS) != 0) {
			loaded = true;
			repaint();
			return false;
		} else {
			return true;
		}
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
	public int getLeft() {
		return x;
	}

	@Override
	public int getTop() {
		return y;
	}

	@Override
	public int getWidth() {
		return w;
	}

	@Override
	public int getHeight() {
		return h;
	}

	@Override
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setSize(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public Shape copy() {
		return (Shape) clone();
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}

	@Override
	public <T> T accept(ShapeVisitor<T> v) {
		return v.visitAdapter(this);
	}

}