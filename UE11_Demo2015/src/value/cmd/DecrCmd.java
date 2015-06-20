package value.cmd;

import value.model.ValueModel;

/**
 * Command class for decrement operations on model. 
 */
public class DecrCmd extends Cmd {
	
	/**
	 * Constructor initializing value model
	 * 
	 * @param model the value model this command operates on
	 */
	public DecrCmd(ValueModel model) {
		super(model);
	}

	/**
	 * Executes this command by decrementing the value in the model
	 */
	@Override
	public void doCmd() {
		model.decr();
		
	}

	/**
	 * Undoes this command by incrementing the value in the model
	 */
	@Override
	public void undoCmd() {
		model.incr();
	}

}
