package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

/**
 * AddShapeCommand.java
 *
 * A {@link AddShapeCommand} is a public class implementing a {@link Command}.
 * It allows adding a Shape to the Shapes Array List of a {@link ShapeModel}.
 * The command can be undone.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * @version 1.0
 */
public class AddShapeCommand implements Command {

	private final ShapeModel model;
	private final Shape s;

	/**
	 * Default constructor.
	 * 
	 * @param model
	 * @param s
	 */
	public AddShapeCommand(ShapeModel model, Shape s) {
		this.model = model;
		this.s = s;
	}

	@Override
	// Javadoc: see super class
	public void doCmd() {
		model.getListShapes().add(s);
		model.fireShapeAdded(s);
	}

	@Override
	// Javadoc: see super class
	public void undoCmd() {
		model.getListShapes().remove(s);
		model.removeSelection(s);
		model.fireShapeRemoved(s);
	}
}
