package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

/**
 * MoveShapeCommand.java
 *
 * A {@link MoveShapeCommand} is a public class implementing a {@link Command}.
 * It allows moving a Shape belonging to a {@link ShapeModel}. The command can
 * be undone.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * @version 1.0
 */
public class MoveShapeCommand implements Command {

	private final ShapeModel model;
	private final Shape s;
	private final int dx;
	private final int dy;
	private final int leftOrig;
	private final int topOrig;

	/**
	 * Default constructor.
	 * 
	 * @param model
	 * @param s
	 * @param dx
	 * @param dy
	 */
	public MoveShapeCommand(ShapeModel model, Shape s, int dx, int dy) {
		this.model = model;
		this.s = s;
		this.dx = dx;
		this.dy = dy;
		leftOrig = s.getLeft();
		topOrig = s.getTop();
	}

	@Override
	// Javadoc: see super class
	public void doCmd() {
		s.setPos(leftOrig + dx, topOrig + dy);
		model.fireShapeChanged(s);
	}

	@Override
	// Javadoc: see super class
	public void undoCmd() {
		s.setPos(leftOrig, topOrig);
		model.fireShapeChanged(s);
	}
}
