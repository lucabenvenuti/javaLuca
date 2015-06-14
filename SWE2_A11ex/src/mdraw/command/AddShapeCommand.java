package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

/**
 * AddShapeCommand.java
 *
 * A {@link AddShapeCommand} is a public class implementing a {@link Command}. It
 * allows adding a .
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class AddShapeCommand implements Command {

	private final ShapeModel model;
	private final Shape s;

	public AddShapeCommand(ShapeModel model, Shape s) {
		super();
		this.model = model;
		this.s = s;
	}

	@Override
	public void doCmd() {
		model.getListShapes().add(s);
		model.fireShapeAdded(s);
	}

	@Override
	public void undoCmd() {
		model.getListShapes().remove(s);
		model.removeSelection(s);
		model.fireShapeRemoved(s);
	}
}
