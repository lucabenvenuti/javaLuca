package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;
import mdraw.visitor.ShapeVisitor;
import mdraw.visitor.StretchVisitor;
import mdraw.visitor.UnstretchVisitor;

/**
 * UnstretchSelectionCommand.java
 *
 * A {@link UnstretchSelectionCommand} is a public class implementing a
 * {@link Command}. It allows unstretching one or more Shapes belonging to a
 * {@link ShapeModel}. The command can be undone.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * @version 1.0
 */
public class UnstretchSelectionCommand implements Command {

	private final ShapeModel model;
	private final Shape[] selected;

	/**
	 * Default constructor.
	 * 
	 * @param model
	 */
	public UnstretchSelectionCommand(ShapeModel model) {
		this.model = model;
		selected = model.getSelected();
	}

	@Override
	// Javadoc: see super class
	public void doCmd() {
		for (Shape s : selected) {
			ShapeVisitor<Void> unstretchVisitor = new UnstretchVisitor();
			s.accept(unstretchVisitor);
		}
		model.fireSelectionChanged(model.getListSelected());
	}

	@Override
	// Javadoc: see super class
	public void undoCmd() {
		for (Shape s : selected) {
			ShapeVisitor<Void> stretchVisitor = new StretchVisitor();
			s.accept(stretchVisitor);
		}
		model.fireSelectionChanged(model.getListSelected());
	}
}
