package othello.model;

import java.util.EventObject;

import othello.Player;
import othello.Pos;

/**
 * PosChangeEvent.java
 *
 * A {@link PosChangeEvent} is a public class extending {@link EventObject}. It
 * has a player and a position.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */

@SuppressWarnings("serial")
public class PosChangeEvent extends EventObject {

	private final Player player;
	private final Pos pos;

	public PosChangeEvent(OthelloModel source, Player player, Pos pos) {
		super(source);
		this.player = player;
		this.pos = pos;
	}

	/**
	 * @return the player.
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the Pos.
	 */
	public Pos getPos() {
		return pos;
	}
}
