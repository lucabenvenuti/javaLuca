package expression;

public class AddExpression extends BinaryExpression{
	

	



	public AddExpression(Expression left, Expression right) {
		super('+', left, right);
	}


	/**
	 * @param op
	 * @param left
	 * @param right
	 * @param value
	 */
	AddExpression(char op, Expression left, Expression right, int value) {
		super(op, left, right, value);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param op
	 * @param left
	 * @param right
	 */
	AddExpression(char op, Expression left, Expression right) {
		super(op, left, right);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void draw(int x, int y) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getCenter() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int evaluate() {

		return left.evaluate()+right.evaluate();
		
	}
	
	
}
