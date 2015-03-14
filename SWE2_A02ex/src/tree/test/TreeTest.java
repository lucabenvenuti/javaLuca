package tree.test;

import expression.Expression;
import expression.ExpressionFactory;
import expression.ExpressionParser;
import tree.BaseExpressionFactory;

public class TreeTest {
	public static void main(String[] args) {
		final ExpressionFactory fact = new BaseExpressionFactory();

		final Expression expression =
		new ExpressionParser().createExpression("20+(9-1)*(17-7)", fact);
		expression.draw(0, 0);
		
		final Expression expression3 =
		new ExpressionParser().createExpression("(9-1)*(17-7)+(9-1)*(17-7)", fact);
		expression3.draw(100,100);
		
		final Expression expression4 =
		new ExpressionParser().createExpression("(9-1)*(17-7)+20", fact);
		expression4.draw(300,300);
		}

}
