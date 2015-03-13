package expression;

public class MulExpression extends BinaryExpression {

	public MulExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public void draw(int x, int y) {
		// TODO Auto-generated method stub	
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCenter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int evaluate(int left, int right) {
		return left * right;
	}
}
