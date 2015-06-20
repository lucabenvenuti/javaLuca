package value.cmd;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Class implementing processor for commands. 
 * Maintains the stacks of undo and redo commands. 
 * Provides access to a singleton command processor.  
 */
public class CmdProcessor {
	
	/** singleton instance */
	private static CmdProcessor instance; 
	
	/** Gets the singleton command processor */
	public static CmdProcessor getInstance() {
		if (instance == null) {
			instance = new CmdProcessor();
		}
		return instance; 
	}
	
	/** undo stack */ 
	private final Deque<Cmd> undoStack; 
	/** redo stack */
	private final Deque<Cmd> redoStack; 
	
	/** private constructor used in singleton access method */ 
	private CmdProcessor() {
		undoStack = new ArrayDeque<Cmd>();
		redoStack = new ArrayDeque<Cmd>();
	}
	
	/** 
	 * Resets this command processor by clearing undo and redo stacks. 
	 */
	public void reset() {
		undoStack.clear();
		redoStack.clear();
	}
	
	/**
	 * Executes the command and pushes it on the undo stack. 
	 * Further, clears the redo stack. 
	 * @param cmd
	 */
	public void doCmd(Cmd cmd) {
		cmd.doCmd();
		undoStack.push(cmd);
		redoStack.clear();
	}
	
	/**
	 * Undoes the top command on the undo stack. 
	 * Puts the command on the redo stack. 
	 */
	public void undoCmd() {
		if (undoStack.isEmpty()) {
			return; 
		}
		Cmd cmd = undoStack.pop();
		cmd.undoCmd();
		redoStack.push(cmd); 
	}
	
	/**
	 * Redoes the top command on the redo stack. 
	 * Puts the command back on the undo stack. 
	 */
	public void redoCmd() {
		if (redoStack.isEmpty()) {
			return; 
		}
		Cmd cmd = redoStack.pop();
		cmd.doCmd();
		undoStack.push(cmd); 
	}
	
}
