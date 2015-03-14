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
	@Override
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
		int w = Window.getTextHeight();
		int c = getCenter();

		Window.drawTextCentered(getValue(), x+c, y+w);
		Window.drawTextCentered(getOperator(), x+c, y+2*w);
		Window.drawLine(x+c, y+3*w, x+left.getCenter(), y+4*w);
		Window.drawLine(x+c, y+3*w, x+c+right.getCenter(), y+4*w);
		left.draw(x, y+3*w);
		right.draw(x+c, y+3*w);
	}

	@Override
	public int getCenter() {
		return (left.getCenter() + right.getCenter()) / 2 + left.getCenter();
//		return getWidth() / 2;
	}
}
