package expression2;

import inout.Window;
import expression.Expression;

public abstract class BinaryExpression implements Expression {
	private final Expression right;
	private final Expression left;
	private static int c=0;

	/**
	 * @param left
	 * @param right
	 */
	BinaryExpression(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * Calculates the arithmetic result of the expression and returns the result.
	 */
	public int evaluate() {
		return evaluate(left.evaluate(), right.evaluate());
	}
	
	abstract int evaluate(int left, int right);

	@Override
	public int getWidth() {
		return left.getWidth() + right.getWidth();
	}

	@Override
	public void draw(int x, int y) {
		c= 50; //c+50;
		Window.drawTextCentered(toString(), x+getCenter()+c, y+c);
		
		left.draw(x-c, c+y);
	//	c= c+getWidth();
		right.draw(c+x+(getCenter()*3/2), c+y);
		
	}


	@Override
	public int getCenter() {
		return getWidth()/2;
	}

	

	
	@Override
	public String toString(){
		return new Integer(evaluate()).toString();
	}
	
}
