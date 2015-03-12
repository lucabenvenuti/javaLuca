package tree;

import expression.AddExpression;
import expression.ConstantExpression;
import expression.Expression;
import expression.ExpressionFactory;
import expression.MulExpression;
import expression.SubExpression;

public class BaseExpressionFactory implements ExpressionFactory {

	/**
	 * @param op
	 * @param left
	 * @param right
	 * @param value
	 */
	BaseExpressionFactory(char op, Expression left, Expression right, int value) {
		this.op = op;
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	BaseExpressionFactory(int value) {
		this((Character) null,null,null,value);
	}
	
	public BaseExpressionFactory() {
		this((Character) null,null,null,(Integer) null);
	}

	private char op;
	private Expression left;
	private Expression right;
	private int value;
	
	@Override
	public Expression createConstant(int value) {
		return new ConstantExpression(value);
	}

	@Override
	public Expression createBinary(char op, Expression left, Expression right) {
		if (op=='+'){return new AddExpression(left, right);}
		else if (op=='-'){return new SubExpression(left, right);}
		else if (op=='*'){return new MulExpression(left, right);}
		else {return null;}
	}

}
