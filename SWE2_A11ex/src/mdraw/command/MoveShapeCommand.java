package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class MoveShapeCommand implements Command {

	private final ShapeModel model;
	private final Shape s;
	private final int dx;
	private final int dy;
	private final int leftOrig;
	private final int topOrig;

	public MoveShapeCommand(ShapeModel model, Shape s, int dx, int dy) {
		this.model = model;
		this.s = s;
		this.dx = dx;
		this.dy = dy;
		leftOrig = s.getLeft();
		topOrig = s.getTop();
	}

	@Override
	public void doCmd() {
		s.setPos(leftOrig + dx, topOrig + dy);
		model.fireShapeChanged(s);
	}

	@Override
	public void undoCmd() {
		s.setPos(leftOrig, topOrig);
		model.fireShapeChanged(s);
	}

}
