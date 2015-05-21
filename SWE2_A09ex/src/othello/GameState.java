package othello;

/**
 * Enumeration class for representing the different states of the game. 
 */
public enum GameState {
	/** Next player white */
	WHITE_NEXT, 
	
	/** Next player blach */
	BLACK_NEXT,

	/** White is winner */
	WHITE_WINS,
	
	/** Black is winner */
	BLACK_WINS,
	
	/** It is a draw */
	DRAW;
	
}

