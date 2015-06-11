package mdraw.shapes;

/**
 * Base class for primitive shapes. <code>PrimitiveShape</code> defines position
 * and width and height {@link #getHeight()}.
 * 
 * @see Shape#copy()
 * @see #getLeft()
 * 
 * @author Herbert Praehofer
 * @version 1.1
 * @since 1.0
 */
abstract public class PrimitiveShape extends Object implements Shape {

	/** x-coordinate of the shape. */
	protected int x;

	/** y-coordinate of the shape. */
	protected int y;

	/** Width of the shape. */
	private int w;

	/** Height of the shape. */
	private int h;

	/**
	 * Constructor setting x- and y- coordinates and width and height.
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @param w
	 *            the width
	 * @param h
	 *            the height
	 */
	public PrimitiveShape(int x, int y, int w, int h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	@Override  // Javadoc: see super class
	public int getLeft() {
		return x;
	}

	@Override  // Javadoc: see super class
	public int getTop() {
		return y;
	}

	@Override  // Javadoc: see super class
	public int getWidth() {
		return w;
	}

	@Override  // Javadoc: see super class
	public int getHeight() {
		return h;
	}

	@Override  // Javadoc: see super class
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override  // Javadoc: see super class
	public void setSize(int w, int h) {
		this.w = w;
		this.h = h;
	}

	/**
	 * Creates a (deep) copy of this shape by creating a shallow clone.
	 * 
	 * @return a clone of this object
	 * 
	 * @see Object#clone
	 */
	public Shape copy() {
		return (Shape)clone();
	}

	@Override  // Javadoc: see super class
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}	

}
