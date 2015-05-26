package othello;

/**
 * Stone.java
 *
 * A {@link Stone} is a public Enumeration class for possible states of a
 * position.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author TAs
 */
public enum Stone {

	/** Position is free. */
	FREE("-"),
	/** Positions occupied by first player. */
	WHITE("0"),
	/** Position occupied by second player. */
	BLACK("X");

	private final String symbol;

	private Stone(String name) {
		this.symbol = name;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public Stone other() {
		if (this == WHITE) {
			return BLACK;
		} else if (this == BLACK) {
			return WHITE;
		} else {
			return FREE;
		}
	}

	public boolean isOther(Stone other) {
		if (this == WHITE) {
			return other == BLACK;
		} else if (this == BLACK) {
			return other == WHITE;
		} else {
			return false;
		}
	}

}
