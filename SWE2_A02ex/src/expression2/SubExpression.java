package expression2;

import expression.Expression;

/**
 * SubExpression.java
 *
 * A {@link SubExpression} is a class which 
 * stores a subtraction expression
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
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
