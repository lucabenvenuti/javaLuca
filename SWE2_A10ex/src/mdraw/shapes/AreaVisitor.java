package mdraw.shapes;

public class AreaVisitor implements Visitor<Integer> {

	@Override
	public Integer visitShape(Shape s) {
		return s.getHeight()*s.getWidth();
	}

}
