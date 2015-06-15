package mdraw.command;

/**
 * Command.java
 *
 * A {@link Command} is a public interface. It
 * has do and undo commands.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 * @version 1.0
 */
public interface Command {

	/**
	 * Perform a command.
	 */
	public void doCmd();
	
	/**
	 * Undo the command performed.
	 */
	public void undoCmd();
}
