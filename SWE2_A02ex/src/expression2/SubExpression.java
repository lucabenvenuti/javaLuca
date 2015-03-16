package expression2;

import expression.Expression;

public class SubExpression extends BinaryExpression {

	public SubExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	int evaluate(int left, int right) {
		return left - right;		
	}
	

	@Override
	String getOperator() {
		return "-";
	}

}
