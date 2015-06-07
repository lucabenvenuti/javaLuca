package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class RemoveShapeCommand implements Command {

	private ShapeModel model;
	private Shape s;

	public RemoveShapeCommand(ShapeModel model, Shape s) {
		super();
		this.model = model;
		assert (s != null);
		this.s = s;
	}

	@Override
	public void doCmd() {
		model.shapes.remove(s);
		model.fireShapeRemoved(s);
		model.removeSelection(s);
	}

	@Override
	public void undoCmd() {
		assert (s != null);
		model.shapes.add(s);
		model.fireShapeAdded(s);
	}

}
