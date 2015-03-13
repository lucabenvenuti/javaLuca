package expression2;

import inout.Window;
import expression.Expression;

public class ConstantExpression implements Expression {

	private final int value;
	
	/**
	 * @param value
	 */
	public ConstantExpression(int value) {
		this.value = value;
	}

	public int evaluate() {
		return this.value;
	}



	@Override
	public int getWidth() {
		return Window.getTextWidth(toString());

	}

	@Override
	public int getCenter() {
		return getWidth()/2;
	}
	
	@Override
	public void draw(int x, int y) {
		int c = 50;
		Window.drawTextCentered(toString(), x+c, y+c);
	}
	
	@Override
	public String toString(){
		return new Integer(value).toString();
	}
}
