package figures;

/**
 * Figure.java
 *
 * A {@link Figure} is an abstract class with
 * a draw abstract method, 3 createAnimation methods
 * and 2 inner classes.
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public abstract class Figure {

	private final int xOrig;
	private final int yOrig;
	protected int x;
	protected int y;

	protected Figure(int x, int y) {
		this.xOrig = this.x = x;
		this.yOrig = this.y = y;
	}

	/**
	 * @param xOrigin
	 * @param yOrigin
	 * Draw the figure from the given origin coordinates
	 */
	public abstract void draw(int xOrigin, int yOrigin);

}