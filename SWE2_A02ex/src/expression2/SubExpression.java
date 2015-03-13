package expression2;

import expression.Expression;

public class SubExpression extends BinaryExpression {

	public SubExpression(Expression left, Expression right) {
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
		return left - right;		
	}
}
