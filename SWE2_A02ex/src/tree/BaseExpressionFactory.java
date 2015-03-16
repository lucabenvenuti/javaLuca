package tree;

import expression.Expression;
import expression.ExpressionFactory;
import expression2.AddExpression;
import expression2.ConstantExpression;
import expression2.MulExpression;
import expression2.SubExpression;

/**
 * BaseExpressionFactory.java
 *
 * A {@link BaseExpressionFactory} is a class which
 * implements the correct sub-class call
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class BaseExpressionFactory implements ExpressionFactory {

	@Override
	public Expression createConstant(int value) {
		return new ConstantExpression(value);
	}

	@Override
	public Expression createBinary(char op, Expression left, Expression right) {
		switch (op){
			case '+':
				return new AddExpression(left, right);
			case '-':
				return new SubExpression(left, right);
			case '*':
				return new MulExpression(left, right);
			default:
				throw new IllegalArgumentException("Op not supported: " + op);
		}
	}
}
