package mdraw.visitor;

import mdraw.shapes.*;

public class AreaVisitor implements ShapeVisitor<Integer> {

	@Override
	public Integer visitRect(Rect r) {
		return r.getHeight() * r.getWidth();
	}

	@Override
	public Integer visitOval(Oval o) {
		return (int) (o.getHeight() * o.getWidth() * Math.PI / 4);
	}

	@Override
	public Integer visitGroup(Group g) {
		int area = 0;
		for (Shape s : g.getElements()) {
			area += s.accept(this);
		}
		return area;
	}

	@Override
	public Integer visitAdapter(ImageAdapter a) {
		return a.getHeight() * a.getWidth();
	}

}
