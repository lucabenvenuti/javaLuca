package cmd;

import java.util.ArrayDeque;
import java.util.Deque;

public class CmdHandler {

	private final Deque<Command> undoStack = new ArrayDeque<>();
	private final Deque<Command> redoStack = new ArrayDeque<>();

/*	public CmdHandler() {
		//this.undoStack
		//this.redoStack
	}*/

	public void doCommand(Command cmd) {
		cmd.doCmd();
		undoStack.addFirst(cmd);
	}

	public void undoCommand() {
		if (undoStack.isEmpty()) {
			return;
		}
		Command cmd = undoStack.getFirst();
		cmd.undoCmd();
		undoStack.removeFirst();
		redoStack.addFirst(cmd);
	}

	public void redoCommand() {
		if (redoStack.isEmpty()) {
			return;
		}
		Command cmd = redoStack.removeFirst();
		doCommand(cmd);
	}

}
