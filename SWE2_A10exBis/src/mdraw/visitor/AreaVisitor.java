package mdraw.visitor;

import mdraw.shapes.Group;
import mdraw.shapes.ImageAdapter;
import mdraw.shapes.Oval;
import mdraw.shapes.Rect;
import mdraw.shapes.Shape;

/**
 * AreaVisitor.java
 *
 * A {@link AreaVisitor} is a public class implementing a {@link ShapeVisitor}. It
 * allows calculating the area of the various shapes.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @param <Integer>
 */
public class AreaVisitor implements ShapeVisitor<Integer> {

	@Override  // Javadoc: see super class
	public Integer visitRect(Rect r) {
		return r.getHeight() * r.getWidth();
	}

	@Override  // Javadoc: see super class
	public Integer visitOval(Oval o) {
		return (int) (o.getHeight() * o.getWidth() * Math.PI / 4);
	}

	@Override  // Javadoc: see super class
	public Integer visitGroup(Group g) {
		int area = 0;
		for (Shape s : g.getElements()) {
			area += s.accept(this);
		}
		return area;
	}

	@Override  // Javadoc: see super class
	public Integer visitAdapter(ImageAdapter a) {
		return a.getHeight() * a.getWidth();
	}

}
