package mdraw.command;

import java.util.List;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class ClearSelectionCommand implements Command {

	private ShapeModel model;
	private final List<Shape> selected;

	public ClearSelectionCommand(ShapeModel model) {
		super();
		this.model = model;
		this.selected = model.selected;
	}

	@Override
	public void doCmd() {
		model.selected.clear();
		model.fireSelectionChanged(model.selected);
	}

	@Override
	public void undoCmd() {
		model.selected.clear();
		model.selected.addAll(selected);
		model.fireSelectionChanged(selected);
	}

}
