package othello;

/**
 * Interface for implementation of players of the Othello game. 
 */
public interface Player {

	
	/** Gets the name of the player. 
	 * @return
	 */
	public String getName();

	/** Gets a next move of the player which is based on the board state. 
	 * Players can compute a next move or move can be inputted. 
	 * @param board the board of the game
	 * @return the move the player wants to take. 
	 */
	public Pos nextMove(Board board);
	
	/**
	 * Sets the stone of this player, either white or black. 
	 * @param stone the stone for this player
	 */
	public void setStone(Stone stone); 
	
	/** 
	 * Gets the stone of this player, either white or black. 
	 * @return the stone for this player
	 */
	public Stone getStone(); 
	
}
