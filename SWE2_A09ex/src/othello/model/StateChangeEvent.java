package othello.model;

import java.util.EventObject;

import othello.GameState;

/**
 * StateChangeEvent.java
 *
 * A {@link StateChangeEvent} is a public class extending {@link EventObject}.
 * It has a player and a position.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class StateChangeEvent extends EventObject {

	private static final long serialVersionUID = -6979328807430005123L;
	private final GameState state;

	public StateChangeEvent(OthelloModel source, GameState state) {
		super(source);
		this.state = state;
	}

	/**
	 * @return the game state
	 */
	public GameState getState() {
		return state;
	}
}
