package mdraw.command;

public interface Command extends Cloneable {

	public void doCmd();
	
	public void undoCmd();
	
}
