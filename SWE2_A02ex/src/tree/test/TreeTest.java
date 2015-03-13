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
		//System.out.println(expression);
	//	System.out.println(expression.evaluate());
	//	System.out.println(expression.getWidth());
		
		final Expression expression2 =
		new ExpressionParser().createExpression("(9-1)*(17-7)", fact);
	//	System.out.println(expression2.evaluate());
	//	System.out.println(expression2.getWidth());
		expression.draw(100, 0);
	//	System.out.println("test");
	/*	final Expression expression3 =
				new ExpressionParser().createExpression("20", fact);
		
		final Expression expression4 =
				new ExpressionParser().createExpression("50", fact);
		expression4.draw(0, 0);*/
		}

	


}
