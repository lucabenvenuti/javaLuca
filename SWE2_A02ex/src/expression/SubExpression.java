package expression;

public class SubExpression extends BinaryExpression{
	

	



	/**
	 * @param op
	 * @param left
	 * @param right
	 * @param value
	 */
	SubExpression(char op, Expression left, Expression right, int value) {
		super(op, left, right, value);
		// TODO Auto-generated constructor stub
	}

	
	public SubExpression(Expression left, Expression right) {
		super('-', left, right);
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

		return left.evaluate()-right.evaluate();
		
	}
	
	
}
