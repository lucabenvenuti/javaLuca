package tree.test;

import inout.Window;
import expression.Expression;
import expression.ExpressionFactory;
import expression.ExpressionParser;
import tree.BaseExpressionFactory;

public class TreeTest {
	public static void main(String[] args) {
		final ExpressionFactory fact = new BaseExpressionFactory();
		final Expression expression =
		new ExpressionParser().createExpression("20+(9-1)*(17-7)", fact);
		
		final Expression expression2 =
		new ExpressionParser().createExpression("(9-1)*(17-7)", fact);
		expression.draw(100, 0);
		}

}
