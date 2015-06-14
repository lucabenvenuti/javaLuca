package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class RemoveSelectionCommand implements Command {

	private final ShapeModel model;
	private final Shape s;

	public RemoveSelectionCommand(ShapeModel model, Shape s) {
		super();
		this.model = model;
		this.s = s;
	}

	@Override
	public void doCmd() {
		model.selected.remove(s);
		model.fireSelectionChanged(model.selected);
	}

	@Override
	public void undoCmd() {
		model.selected.add(s);
		model.fireSelectionChanged(model.selected);
	}
}
