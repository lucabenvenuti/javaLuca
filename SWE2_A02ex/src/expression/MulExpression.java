package expression;

public class MulExpression extends BinaryExpression{
	

	



	public MulExpression(Expression left, Expression right) {
		super('*', left, right);
	}


	/**
	 * @param op
	 * @param left
	 * @param right
	 */
	MulExpression(char op, Expression left, Expression right) {
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

		return left.evaluate()*right.evaluate();
		
	}
	
	
}
