package mdraw.command;

import java.util.Arrays;
import java.util.List;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class SetSelectionCommand implements Command {

	private ShapeModel model;
	private Shape[] s;
	private final List<Shape> selected;

	public SetSelectionCommand(ShapeModel model, Shape[] s) {
		super();
		this.model = model;
		this.selected = model.selected;
		this.s = s;
	}

	@Override
	public void doCmd() {
		model.selected.clear();
		model.selected.addAll(Arrays.asList(s));
		model.fireSelectionChanged(model.selected);
	}

	@Override
	public void undoCmd() {
		model.selected.clear();
		model.selected.addAll(selected);
		model.fireSelectionChanged(selected);
	}

}
