package expression2;

import inout.Window;
import expression.Expression;

/**
 * BinaryExpression.java
 *
 * A {@link BinaryExpression} is a super-class for 
 * all binary expressions
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
abstract class BinaryExpression implements Expression {
	protected final Expression right;
	protected final Expression left;
	
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
	
	/** 
	 * it draws the node and its leaves
	 */
	@Override
	public void draw(int x, int y) {
		int h = Window.getTextHeight();
		int c = getCenter();

		Window.drawTextCentered(getValue(), x+c, y+h);
		Window.drawTextCentered(getOperator(), x+c, y+2*h);
		Window.drawLine(x+c, y+3*h, x+left.getCenter(), y+4*h);
		Window.drawLine(x+c, y+3*h, x+left.getWidth()+right.getCenter(), y+4*h);
		left.draw(x, y+3*h);
		right.draw(x+left.getWidth(), y+3*h);
	}

	@Override
	public int getCenter() {
		return (left.getCenter() + right.getCenter()) / 2 + left.getCenter();
	}
}
