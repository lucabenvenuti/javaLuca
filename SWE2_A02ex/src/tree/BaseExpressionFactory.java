package tree;

import expression.Expression;
import expression.ExpressionFactory;
import expression2.AddExpression;
import expression2.ConstantExpression;
import expression2.MulExpression;
import expression2.SubExpression;

public class BaseExpressionFactory implements ExpressionFactory {

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
