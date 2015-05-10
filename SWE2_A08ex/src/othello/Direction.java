package othello;

/**
 * Enumeration class for directions in a chessboard. 
 * Each direction value stores the change of indices to go 
 * from a position one step into that direction. 
 */
public enum Direction {
	
	N(-1, 0), NW(-1, -11), W(0, -1), SW(1, -1), S(1, 0), SE(1, 1), E(0, 1), NE(-1, 1); 
	
	/** change of row index */
	public final int dRow; 
	/** change of column index */
	public final int dCol; 
	
	/** 
	 * Constructor setting change of row and column index
	 * @param dRow the change of row index
	 * @param dCol the change of column index
	 */
	private Direction(int dRow, int dCol) {
		this.dRow = dRow; 
		this.dCol = dCol; 
	}
	
}
