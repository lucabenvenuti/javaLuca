package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class AddShapeCommand implements Command {
	
	private ShapeModel model;
	private Shape s;
	

	public AddShapeCommand(ShapeModel model, Shape s) {
		super();
		this.model = model;
		this.s = s;
	}

	@Override
	public void doCmd() {
		assert (s != null);
		model.shapes.add(s);
		model.fireShapeAdded(s);
	}

	@Override
	public void undoCmd() {
		assert (s != null);
		model.shapes.remove(s);
		model.fireShapeRemoved(s);
		model.removeSelection(s);		
	}

}
