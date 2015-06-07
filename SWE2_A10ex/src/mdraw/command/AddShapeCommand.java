package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class AddShapeCommand implements Command {

	private ShapeModel model;
	private Shape s;

	public AddShapeCommand(ShapeModel model, Shape s) {
		super();
		this.model = model;
		assert (s != null);
		this.s = s;
	}

	@Override
	public void doCmd() {
		model.shapes.add(s);
		model.fireShapeAdded(s);
	}

	@Override
	public void undoCmd() {
		model.shapes.remove(s);
		model.fireShapeRemoved(s);
		model.removeSelection(s);
	}

}
