package expression;

public class ConstantExpression implements Expression{
	
	private int value;

	
	/**
	 * @param value
	 */
	
	public ConstantExpression(int value) {
		this.value = value;
	}




	public int evaluate() {
		// TODO Auto-generated method stub
		return this.value;
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
	
	
}
