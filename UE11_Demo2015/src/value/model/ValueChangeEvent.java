package value.model;

import java.util.EventObject;

@SuppressWarnings("serial")
public class ValueChangeEvent extends EventObject {
	
	public static enum ChangeType {
		Incr, Decr, Set, Reset
	}
	
	private final int value;
	private final ChangeType change; 

	public ValueChangeEvent(ValueModel source, int value, ChangeType change) {
		super(source);
		this.value = value;
		this.change = change;
	}

	public int getValue() {
		return value;
	}

	public ChangeType getChange() {
		return change;
	}
	
}
