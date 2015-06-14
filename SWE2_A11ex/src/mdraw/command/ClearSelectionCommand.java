package mdraw.command;

import java.util.ArrayList;
import java.util.List;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class ClearSelectionCommand implements Command {

	private final ShapeModel model;
	private final ArrayList<Shape> selected;

	public ClearSelectionCommand(ShapeModel model) {
		super();
		this.model = model;
		this.selected = (ArrayList)model.selected.clone(); //TODO: clone method in ShapeModel with return ArrayList
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
