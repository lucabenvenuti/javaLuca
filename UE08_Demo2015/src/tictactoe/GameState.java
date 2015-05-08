package tictactoe;

/**
 * Possible states of the game.
 */
public enum GameState {
	
	/** Game still running. */
	RUNNING("Running"),
	
	/** First player has won. */
	WINNER_PLAYER_X("X_Won"),
	
	/** Second player has won. */
	WINNER_PLAYER_O("O_Won"),
	
	/** Game is draw, i.e. all positions filled but no winner. */
	DRAW("Draw");
	
	/** the label string for output */
	private final String label; 

	/** private constructor initializing label */
	private GameState(String label) {
		this.label = label; 
	}

	/** Gets the label for outputting this game state.
	 * @return the label for output
	 */
	public String getLabel() {
		return label;
	}
	
}

