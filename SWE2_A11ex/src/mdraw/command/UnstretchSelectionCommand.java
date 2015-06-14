package mdraw.command;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;
import mdraw.visitor.ShapeVisitor;
import mdraw.visitor.StretchVisitor;
import mdraw.visitor.UnstretchVisitor;

public class UnstretchSelectionCommand implements Command {

	private ShapeModel model;

	public UnstretchSelectionCommand(ShapeModel model) {
		super();
		this.model = model;
	}

	@Override
	public void doCmd() {
		Shape[] selected = model.getSelected();
		if (selected.length < 1) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Please select at least one element", "Dialog",
					JOptionPane.ERROR_MESSAGE);
		}
		for (Shape s : selected) {
			ShapeVisitor<Void> unstretchVisitor = new UnstretchVisitor();
			s.accept(unstretchVisitor);
		}
		model.fireSelectionChanged(model.selected);
	}

	@Override
	public void undoCmd() {
		Shape[] selected = model.getSelected();
		for (Shape s : selected) {
			ShapeVisitor<Void> stretchVisitor = new StretchVisitor();
			s.accept(stretchVisitor);
		}
		model.fireSelectionChanged(model.selected);
	}

}
