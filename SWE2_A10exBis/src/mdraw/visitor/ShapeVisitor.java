package mdraw.visitor;

import mdraw.shapes.Group;
import mdraw.shapes.ImageAdapter;
import mdraw.shapes.Oval;
import mdraw.shapes.Rect;

/**
 * ShapeVisitor.java
 *
 * A {@link ShapeVisitor} is a public class implementing a visitor pattern. It
 * allows visiting the various shapes.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @param <T>
 */
public interface ShapeVisitor<T> {

	/**
	 * Visit a Rect shape.
	 * 
	 * @param r
	 * @return a generic object T
	 */
	public T visitRect(Rect r);

	/**
	 * Visit an Oval shape.
	 * 
	 * @param o
	 * @return a generic object T
	 */
	public T visitOval(Oval o);

	/**
	 * Visit a Group shape.
	 * 
	 * @param g
	 * @return a generic object T
	 */
	public T visitGroup(Group g);

	/**
	 * Visit an ImageAdapter shape.
	 * 
	 * @param a
	 * @return a generic object T
	 */
	public T visitAdapter(ImageAdapter a);
}
