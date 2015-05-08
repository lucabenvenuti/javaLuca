package tictactoe;

/**
 * Specifies the positions in the 3x3 grid of the board by an enumeration.  
 */
public enum  Pos {
	
	/* Enumeration values with A, B, C for lines and 1, 2, 3 for columns */
	A_1('A', 1), A_2('A', 2), A_3('A', 3), 
	B_1('B', 1), B_2('B', 2), B_3('B', 3), 
	C_1('C', 1), C_2('C', 2), C_3('C', 3); 
	
	/** Array of all position values */
	public static Pos[] ALL = Pos.values(); 
	
	/** Gets the position for row and column.
	 * @param row the character designating the row
	 * @param col the integer value designating the column
	 * @return the position value
	 */
	public static Pos getPos(char row, int col) throws IllegalArgumentException {
		row = Character.toUpperCase(row); 
		if (row < 'A' || row > 'C' || col < 1 || col > 3) {
			throw new IllegalArgumentException("Illegal argument to getPos; was " + row + "_" + col); 
		}
		int index = (row - 'A') * 3 + (col - 1); 
		return Pos.values()[index]; 
	}
	
	/** The column index of the position. */
	private final int col;

	/** The row character of the position. */
	private final char row;

	/**
	 * Constructor that initializes the coordinate.
	 * 
	 * @param col
	 *            The column of the position.
	 * @param row
	 *            The row of the position.
	 */
	private Pos(char row, int col) {
		assert col >= 1 && col <= 3;
		assert row >= 'A' && row <= 'C';

		this.col = col;
		this.row = row;
	}

	/**
	 * Accessor for the column.
	 * 
	 * @return The column  of the position.
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Accessor for the row.
	 * 
	 * @return The row of the position.
	 */
	public char getRow() {
		return row ;
	}
}
