package cmd;

public class Client {

	public static void main(String[] args) {

		Light lamp = new Light();

		Command switchUp = new BrighterCommand(lamp, 3);
		Command switchDown = new FlipDownCommand(lamp, 2);

		CmdHandler handler = new CmdHandler();

		handler.doCommand(switchUp);
		handler.doCommand(switchDown);
		System.out.print("Undo: ");
		handler.undoCommand();
		System.out.print("Undo: ");
		handler.undoCommand();
		System.out.print("Redo: ");
		handler.redoCommand();
		System.out.print("Redo: ");
		handler.redoCommand();

	}

}
