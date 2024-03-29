package othello;

/**
 * User interface component used by the game for interaction. 
 */
public interface UserInterface {

	/**
	 * Called when the board changes. 
	 * @param board the board of the game
	 */
	public void boardChanged(Board board);
	
	/**
	 * Called when a stome is set. 
	 * @param pos the position where the stone has been set
	 * @param stone the stone set
	 */
	public void stoneSet(Pos pos, Stone stone);

	/**
	 * Called when the game is over
	 * @param game the game 
	 */
	public void gameOver(Game game);
	
}
