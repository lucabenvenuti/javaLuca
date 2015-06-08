package mdraw.visitor;

import mdraw.shapes.Group;
import mdraw.shapes.ImageAdapter;
import mdraw.shapes.Oval;
import mdraw.shapes.Rect;
import mdraw.shapes.Shape;

/**
 * UnstretchVisitor.java
 *
 * A {@link UnstretchVisitor} is a public class implementing a {@link ShapeVisitor}. It
 * allows unstretching the area of the various shapes.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * 
 * @param <Void>
 */
public class UnstretchVisitor implements ShapeVisitor<Void> {

	@Override
	public Void visitRect(Rect r) {
		r.setSize(r.getWidth(), Math.round((float) r.getHeight() / 2));
		return null;
	}

	@Override
	public Void visitOval(Oval o) {
		o.setSize(Math.round((float) o.getWidth() / 2), o.getHeight());
		return null;
	}

	@Override
	public Void visitGroup(Group g) {
		for (Shape s : g.getElements()) {
			s.setSize(Math.round((float) s.getWidth() / 2),
					Math.round((float) s.getHeight() / 2));
		}
		return null;
	}

	@Override
	public Void visitAdapter(ImageAdapter a) {
		return null;
	}

}
