package expression2;

import inout.Window;
import expression.Expression;

/**
 * ConstantExpression.java
 *
 * A {@link ConstantExpression} is a class which 
 * stores a value.
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class ConstantExpression implements Expression {

	private final int value;
	
	public ConstantExpression(int value) {
		this.value = value;
	}

	@Override
	public int evaluate() {
		return this.value;
	}

	@Override
	public int getWidth() {
		return 10+Window.getTextWidth(toString());
	}

	@Override
	public int getCenter() {
		return getWidth() / 2;
	}

	@Override
	public void draw(int x, int y) {
		Window.drawTextCentered(toString(), x + getCenter(), y + Window.getTextHeight());
	}

	@Override
	public String toString(){
		return String.valueOf(value);
	}
}
