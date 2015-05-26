package othello;

/**
 * Board.java
 *
 * A {@link Board} is a public interface for board of the Othello game. The
 * board allows to set stones on positions, get the stone for positions, turn
 * stones on positions, test if positions are free, test if the board is full,
 * get all positions where stones can be set as next move and print the board on
 * an output writer.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author TAs & Luca Benvenuti
 */
public interface Board extends Iterable<Pos> {

	/**
	 * Gets the stone at the given position
	 * 
	 * @param pos
	 *            the board position
	 * @return the stone on that position, maybe free
	 */
	public abstract Stone getStone(Pos pos);

	/**
	 * Sets a stone at the given position and turns all stones of other color
	 * which get enclosed by setting this stone. Important: Has to check all
	 * directions if stones of other colors get enclosed!!!!
	 * 
	 * @param pos
	 *            the board position
	 * @param stone
	 *            stone to set on position
	 */
	public abstract void setStone(Pos pos, Stone stone);

	/**
	 * Tests if the given position is free
	 * 
	 * @param pos
	 *            the board position
	 * @return <code>true</code> if position is free, <code>false</code>
	 *         otherwise
	 */
	public abstract boolean isFree(Pos pos);

	/**
	 * Tests if the board is full
	 * 
	 * @return <code>true</code> if borad is full, <code>false</code> otherwise
	 */
	public abstract boolean isFull();

	/**
	 * Returns an array of all positions which are valid moves for given stone
	 * 
	 * @param stone
	 *            the stone for the move
	 * @return positions which represent valid moves for the given stone
	 */
	public abstract Pos[] getValidPositions(Stone stone);

	/**
	 * Reset the Board to the initial conditions.
	 */
	public void reset();

}