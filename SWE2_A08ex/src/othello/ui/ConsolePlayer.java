package othello.ui;

import inout.In;
import inout.Out;
import othello.Board;
import othello.Player;
import othello.Pos;
import othello.Stone;

/**
 * Implementation of a player interacting using the console. 
 */
public class ConsolePlayer implements Player {
	
	/** Name of the player */
	private final String name; 
	/** Stone of this player */
	private Stone stone; 

	/**
	 * Constructor initializing the name of the player.
	 * @param name the name of this player
	 */
	public ConsolePlayer(String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see othello.Player#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see othello.Player#nextMove(othello.Board)
	 */
	@Override
	public Pos nextMove(Board board) {
		Out.println(); 
		Out.println("Move of " + getName() + " with stone " + this.getStone());
		Pos[] valid = board.getValidPositions(this.getStone());
		if (valid.length == 0) {
			Out.println("No valid position for you!");
			return null;
		} else {
			Out.println("Selection one of the following positions: ");
			int i = 1;
			for (Pos pos : valid) {
				Out.println("   " + i + ": " + pos);
				i++;
			}
			Out.print("Select: "); 
			int selected = In.readInt(); 
			while (selected < 1 || selected > valid.length) {
				Out.print("Wront input! Select: "); 
				selected = In.readInt(); 
			}
			return valid[selected-1];
		}
	}

	/* (non-Javadoc)
	 * @see othello.Player#setStone(othello.Stone)
	 */
	@Override
	public void setStone(Stone stone) {
		this.stone = stone;
	}

	/* (non-Javadoc)
	 * @see othello.Player#getStone()
	 */
	@Override
	public Stone getStone() {
		return stone; 
	}

}
