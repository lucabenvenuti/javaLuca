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

	abstract String getOperator();

	String getValue() {
		return String.valueOf(evaluate());
	}
	@Override
	public int getWidth() {
		return left.getWidth() + right.getWidth();
	}
	
	@Override
	public void draw(int x, int y) {
		Window.drawTextCentered(getValue(), x+50, y+50);
		Window.drawTextCentered(getOperator(), x+50, y+70);
		Window.drawLine(x+50, y+90, x+10, y+100);
			Window.drawLine(x+50, y+90, 110+x, y+100);
			left.draw(x-50, 50+y);
			right.draw(50+x+(getCenter()*3/2), 50+y);
	}

	@Override
	public int getCenter() {
		return getWidth() / 2;
	}
}
