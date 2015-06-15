package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

/**
 * ResizeShapeCommand.java
 *
 * A {@link ResizeShapeCommand} is a public class implementing a {@link Command}
 * . It allows resizing a Shape belonging to the Shapes Array List of a
 * {@link ShapeModel}. The command can be undone.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * @version 1.0
 */
public class ResizeShapeCommand implements Command {

	private final ShapeModel model;
	private final Shape s;
	private final int w;
	private final int h;
	private final int widthOrig;
	private final int heightOrig;

	/**
	 * Default constructor.
	 * 
	 * @param model
	 * @param s
	 * @param w
	 * @param h
	 */
	public ResizeShapeCommand(ShapeModel model, Shape s, int w, int h) {
		this.model = model;
		this.s = s;
		this.w = w;
		this.h = h;
		widthOrig = s.getWidth();
		heightOrig = s.getHeight();
	}

	@Override
	// Javadoc: see super class
	public void doCmd() {
		s.setSize(w, h);
		model.fireShapeChanged(s);
	}

	@Override
	// Javadoc: see super class
	public void undoCmd() {
		s.setSize(widthOrig, heightOrig);
		model.fireShapeChanged(s);
	}

}
