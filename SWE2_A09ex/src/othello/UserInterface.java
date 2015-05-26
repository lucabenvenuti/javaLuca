package othello;

/**
 * UserInterface.java
 *
 * A {@link UserInterface} is an User interface component used by the game for
 * interaction.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author TAs & Luca Benvenuti
 * 
 */
public interface UserInterface {

	/**
	 * Called when the board changes.
	 * 
	 * @param board
	 *            the board of the game
	 */
	public void boardChanged(Board board);

	/**
	 * Called when a stone is set.
	 * 
	 * @param pos
	 *            the position where the stone has been set
	 * @param stone
	 *            the stone set
	 */
	public void stoneSet(Pos pos, Stone stone);

	/**
	 * Called when the game is over
	 * 
	 * @param gameState
	 *            the game state
	 */
	public void gameOver(GameState gameState);

	/**
	 * Called to reset the board.
	 * 
	 * @param board
	 *            the board of the game
	 */
	public void reset(Board board);
}
