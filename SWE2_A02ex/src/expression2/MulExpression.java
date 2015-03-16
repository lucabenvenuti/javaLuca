package expression2;

import expression.Expression;

/**
 * MulExpression.java
 *
 * A {@link MulExpression} is a class which 
 * stores a product expression
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class MulExpression extends BinaryExpression {

	public MulExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	int evaluate(int left, int right) {
		return left * right;
	}
		
	@Override
	String getOperator() {
		return "*";
	}

}
