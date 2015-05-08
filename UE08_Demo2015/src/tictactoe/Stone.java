package tictactoe;

/**
 * Possible states of a position.
 */
public enum Stone {
	
	/** Positions occupied by first player. */
	X("X"),
	/** Position occupied by second player. */
	O("O"), 
	/** Position is free. */
	FREE("-"); 
	
	/** a print label for the stone */ 
	private final String label; 
	
	/** private constructor initializing the print label */
	private Stone(String label) {
		this.label = label; 
	}
	
	/**
	 * Returns the print label of this position state
	 * @return the print label string
	 */
	public String getLabel() {
		return label; 
	}
	
	/**
	 * Gets the other stone for this stone. 
	 * @return the other stone for this stone  
	 */
	public Stone other() {
		if (this == X) {
			return O;
		} else if (this == O) {
			return X;
		} else {
			return FREE; 
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return label;
	}
	
}
