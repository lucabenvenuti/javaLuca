package mdraw.command;

import mdraw.model.ShapeModel;
import mdraw.shapes.Shape;

public class ResizeShapeCommand implements Command {

	private ShapeModel model;
	private Shape s;
	private int w;
	private int h;
	private int widthOrig;
	private int heightOrig;

	public ResizeShapeCommand(ShapeModel model, Shape s, int w, int h) {
		super();
		this.model = model;
		this.s = s;
		this.w = w;
		this.h = h;
		widthOrig = s.getWidth();
		heightOrig = s.getHeight();
	}

	@Override
	public void doCmd() {
		s.setSize(w, h);
		model.fireShapeChanged(s);
	}

	@Override
	public void undoCmd() {
		s.setSize(widthOrig, heightOrig);
		model.fireShapeChanged(s);
	}

}
