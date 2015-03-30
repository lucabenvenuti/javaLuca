package figures;

/**
 * Figure.java
 *
 * A {@link Figure} is an abstract class with a draw abstract method.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public abstract class Figure {

	protected int x;
	protected int y;

	protected Figure(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @param xOrigin
	 * @param yOrigin
	 *            Draw the figure from the given origin coordinates
	 */
	public abstract void draw(int xOrigin, int yOrigin);

}
