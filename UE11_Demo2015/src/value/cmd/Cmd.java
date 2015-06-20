package value.cmd;

import value.model.ValueModel;

/**
 * Base class for commands on value model
 */
public abstract class Cmd {
	
	/** the value model */
	protected final ValueModel model; 
	
	/**
	 * Constructor initializing value model
	 * @param model the value model this command operates on
	 */
	public Cmd(ValueModel model) {
		super();
		this.model = model;
	}

	/**
	 * Executes this command.
	 */
	public abstract void doCmd();
	
	/**
	 * Undoes this command.
	 */
	public abstract void undoCmd();
	
}
