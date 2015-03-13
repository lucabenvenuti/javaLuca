package expression2;

import inout.Window;
import expression.Expression;

public abstract class BinaryExpression implements Expression {
	protected final Expression right;
	protected final Expression left;
	
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
	
	public void draw(int x, int y, char c) {
		Window.drawTextCentered(toString(), x+50, y+50);
		Window.drawTextCentered(Character.toString(c), x+50, y+70);
		Window.drawLine(x+50, y+90, x+10, y+100);
			Window.drawLine(x+50, y+90, 110+x, y+100);
		
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
