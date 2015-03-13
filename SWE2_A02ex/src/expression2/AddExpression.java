package expression2;

import inout.Window;
import expression.Expression;

public class AddExpression extends BinaryExpression{

	public AddExpression(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public int evaluate(int left, int right) {
		return left + right;
	}

	@Override
	public void draw(int x, int y) {
		int c= 50; 
		draw(x,y,'+');
		left.draw(x-c, c+y);
		right.draw(c+x+(getCenter()*3/2), c+y);
		
	}


	
}
