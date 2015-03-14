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
		return left.getWidth() + right.getWidth();// +20;
	}
	
	@Override
	public void draw(int x, int y) {
		Window.drawTextCentered(getValue(), x+getCenter(), y+Window.getTextHeight());
		Window.drawTextCentered(getOperator(), x+getCenter(), y+2*Window.getTextHeight());
		Window.drawLine(x+getCenter(), y+3*Window.getTextHeight(), x+left.getCenter(), y+4*Window.getTextHeight());
		Window.drawLine(x+getCenter(), y+3*Window.getTextHeight(), x+getCenter()+right.getCenter(), y+4*Window.getTextHeight());
		left.draw(x, y+3*Window.getTextHeight());
		right.draw(x+getCenter(), y+3*Window.getTextHeight());
	}

	@Override
	public int getCenter() {
		return getWidth() / 2;
	}
}
