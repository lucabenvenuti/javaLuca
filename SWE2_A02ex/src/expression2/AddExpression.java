package expression2;

import expression.Expression;

/**
 * AddExpression.java
 *
 * A {@link AddExpression} is a class which 
 * stores an adding expression
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class AddExpression extends BinaryExpression{

	public AddExpression(Expression left, Expression right) {
		super(left, right);
	}	

	@Override
	int evaluate(int left, int right) {
		return left + right;
	}

	@Override
	String getOperator() {
		return "+";
	}

}
