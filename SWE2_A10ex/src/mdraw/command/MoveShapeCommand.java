package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class MoveShapeCommand implements Command {

	private ShapeModel model;
	private Shape s;
	private int dx;
	private int dy;
	private int leftOrig;
	private int topOrig;



	public MoveShapeCommand(ShapeModel model, Shape s, int dx, int dy) {
		super();
		this.model = model;
		//assert (s != null);
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
