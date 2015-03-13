package expression2;

import inout.Window;
import expression.Expression;

public abstract class BinaryExpression implements Expression {
	protected final Expression right;
	protected final Expression left;
	//private static int c=0;

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

/*	@Override
	public void draw(int x, int y) {
		int c= 50; //c+50;
	
		left.draw(x-c, c+y);
	//	c= c+getWidth();
		right.draw(c+x+(getCenter()*3/2), c+y);
		
	}*/
	
	
	public void draw(int x, int y, char c) {
		Window.drawTextCentered(toString(), x+getCenter()+c, y+c);
		int d = 60; //c+50;
		Window.drawTextCentered(Character.toString(c), x+getCenter()+c, y+d);
		System.out.println(x+getCenter()+c);
		System.out.println(y+d);
		System.out.println("trota");
		Window.drawLine(x+getCenter()+c, y+d+20, x-c+40, y+d+40);
			Window.drawLine(x+getCenter()+c, y+d+20, c+x+(getCenter()*4), y+d+30);
		
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
