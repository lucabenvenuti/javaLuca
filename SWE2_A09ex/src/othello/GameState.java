package othello;

/**
 * GameState.java
 *
 * A {@link GameState} is a public Enumeration class for representing the
 * different states of the game.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author TAs
 */
public enum GameState {
	/** Next player white */
	WHITE_NEXT,

	/** Next player black */
	BLACK_NEXT,

	/** White is winner */
	WHITE_WINS,

	/** Black is winner */
	BLACK_WINS,

	/** It is a draw */
	DRAW;

}
