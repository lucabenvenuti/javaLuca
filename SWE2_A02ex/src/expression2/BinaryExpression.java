package expression2;

import expression.Expression;

public abstract class BinaryExpression implements Expression {
	private final Expression right;
	private final Expression left;

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
