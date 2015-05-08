package tictactoe;

/**
 * Interface definition for the TicTacToe play field. The field maintains the
 * stones set by two players X and O and checks if the game is over, but does not
 * maintain the players itself.
 */
public interface TTTGame {
	
	/**
	 * Gets the state of the game, i.e. checks if the game is still
	 * running, if one of the player has won, or if the game is draw. 
	 * 
	 * @return The state of the game.
	 */
	public GameState getGameState();

	/**
	 * Returns the stone at the specified position.
	 * 
	 * @param pos
	 *            The position.
	 * @return The stone at the board.
	 */
	public Stone getStone(Pos pos);

	/** Tests if this position is free.
	 * @param pos the position to test
	 * @return true if free
	 */
	public boolean isFree(Pos pos); 
	
	/**
	 * Returns the number of the current move.
	 * 
	 * @return The move number, starting with 0.
	 */
	public int getMoveNumber();

	/**
	 * Performs a move at the specified position for the current player.
	 * 
	 * @param pos
	 *            The position for the move.
	 */
	public void doMove(Pos pos);
	
}
