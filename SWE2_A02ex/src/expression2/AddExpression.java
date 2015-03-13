package expression2;

import expression.Expression;

public class AddExpression extends BinaryExpression{

	public AddExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int evaluate(int left, int right) {
		return left + right;
	}
	
}
