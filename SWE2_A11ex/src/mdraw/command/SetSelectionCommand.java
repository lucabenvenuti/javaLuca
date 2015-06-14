package mdraw.command;

import java.util.ArrayList;
import java.util.Arrays;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class SetSelectionCommand implements Command {

	private final ShapeModel model;
	private final Shape[] s;
	private final ArrayList<Shape> selected;

	public SetSelectionCommand(ShapeModel model, Shape[] s) {
		super();
		this.model = model;
		this.selected = (ArrayList)model.selected.clone(); //TODO: clone method in ShapeModel with return ArrayList
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
