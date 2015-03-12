package expression;

public abstract class BinaryExpression implements Expression{
	//abstract class AbstractMovie implements Movie {


	
	Expression right;
	Expression left;
	char op;
	int value;

	/**
	 * @param op
	 * @param left
	 * @param right
	 */
	BinaryExpression(char op, Expression left, Expression right, int value) {
		this.op = op;
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public BinaryExpression() {
		this((Character) null, null, null, (Integer) null);
	}

	public BinaryExpression(int value) {
		this((Character) null, null, null, value);
	}
	

	BinaryExpression(char op, Expression left, Expression right) {
		this(op,left,right, (Integer) null);
	}

	/* (non-Javadoc)
	 * @see expression.Expression#evaluate()
	 */
	

	
/*	@Override
	public int evaluate(){
		if (this.left==null && this.right==null){
			return this.value;
		}
		else if (this.left==null){return this.right.evaluate();}
		else if (this.right==null){return this.left.evaluate();}
		else {
		
		if (op=='+'){return this.left.evaluate()+this.right.evaluate();}
		else if (op=='-'){return this.left.evaluate()-this.right.evaluate();}
		else if (op=='*'){return this.left.evaluate()*this.right.evaluate();}
		else {return 0;}
		}
	}*/
	
	
	
}
