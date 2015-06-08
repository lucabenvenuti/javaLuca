package mdraw.visitor;

import mdraw.shapes.*;

public class StretchVisitor implements ShapeVisitor<Void> {

	@Override
	public Void visitRect(Rect r){
		r.setSize(r.getWidth(), r.getHeight()*2);
		return null;
	}

	@Override
	public Void visitOval(Oval o) {
		o.setSize(o.getWidth()*2, o.getHeight());
		return null;
	}

	@Override
	public Void visitGroup(Group g) {
		for (Shape s : g.getElements()) {
			s.setSize(s.getWidth()*2, s.getHeight()*2);
		}
		return null;
	}

	@Override
	public Void visitAdapter(ImageAdapter a) {
		return null;
	}

}
