package value.cmd;

import value.model.ValueModel;

/**
 * Command class for increment operations on model. 
 */
public class IncrCmd extends Cmd {
	
	/**
	 * Constructor initializing value model
	 * 
	 * @param model the value model this command operates on
	 */
	public IncrCmd(ValueModel model) {
		super(model);
	}

	/**
	 * Executes this command by incrementing the value in the model
	 */
	@Override
	public void doCmd() {
		model.incr();
		
	}

	/**
	 * Undoes this command by decrementing the value in the model
	 */
	@Override
	public void undoCmd() {
		model.decr();
	}

}
