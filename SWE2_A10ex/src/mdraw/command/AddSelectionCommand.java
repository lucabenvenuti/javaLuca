package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class AddSelectionCommand implements Command {
	
	private ShapeModel model;
	private Shape s;
	

	public AddSelectionCommand(ShapeModel model, Shape s) {
		super();
		this.model = model;
		this.s = s;
	}

	@Override
	public void doCmd() {
		if (model.selected.add(s)) {
			model.fireSelectionChanged(model.selected);
		}
	}

	@Override
	public void undoCmd() {
		if (model.selected.remove(s)) {
			model.fireSelectionChanged(model.selected);
		}	
	}

}
