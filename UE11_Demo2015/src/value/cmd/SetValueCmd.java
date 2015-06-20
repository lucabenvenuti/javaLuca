package value.cmd;

import value.model.ValueModel;

public class SetValueCmd extends Cmd {
	
	/** the new value of the model */ 
	private final int value; 
	
	/** the old value of the model */ 
	private final int previous; 
	
	/**
	 * Constructor initializing value model and the new int value. 
	 * Stores the previous value of the model
	 * 
	 * @param model the value model this command operates on
	 * @param value the new value to be set
	 */
	public SetValueCmd(ValueModel model, int value) {
		super(model);
		this.value = value; 
		this.previous = model.getValue(); 
	}

	/**
	 * Executes this command by setting the value of the model to new value. 
	 */
	@Override
	public void doCmd() {
		model.setValue(value);	
	}

	/**
	 * Undoes this command by setting the old value in this model. 
	 */
	@Override
	public void undoCmd() {
		model.setValue(previous);	
	}

}
