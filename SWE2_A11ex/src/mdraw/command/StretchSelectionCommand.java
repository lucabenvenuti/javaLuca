package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;
import mdraw.visitor.ShapeVisitor;
import mdraw.visitor.StretchVisitor;
import mdraw.visitor.UnstretchVisitor;

public class StretchSelectionCommand implements Command {

	private final ShapeModel model;
	private final Shape[] selected;

	public StretchSelectionCommand(ShapeModel model) {
		super();
		this.model = model;
		selected = model.getSelected();
	}

	@Override
	public void doCmd() {
		for (Shape s : selected) {
			ShapeVisitor<Void> stretchVisitor = new StretchVisitor();
			s.accept(stretchVisitor);
		}
		model.fireSelectionChanged(model.selected);	
	}

	@Override
	public void undoCmd() {
		for (Shape s : selected) {
			ShapeVisitor<Void> unstretchVisitor = new UnstretchVisitor();
			s.accept(unstretchVisitor);
		}
		model.fireSelectionChanged(model.selected);
	}
}
