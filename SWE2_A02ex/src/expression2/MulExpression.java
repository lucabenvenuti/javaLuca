package expression2;

import inout.Window;
import expression.Expression;

public class MulExpression extends BinaryExpression {

	public MulExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int evaluate(int left, int right) {
		return left * right;
	}
	
	
	
	@Override
	String getOperator() {
		return "*";
	}

}
