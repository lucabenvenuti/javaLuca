//package at.jku.pervasive.swe14.UE12.vector;
import java.util.*;

public class VectorOfStrings {
	public static void main(String[] args) {
		final String STOPPER = "quit";
		Vector<String> lines = new Vector<String>();
		System.out.println("Enter lines. Use " + STOPPER + " to end the program.");
		while (true) {
			String line = Input.readString();
			if (line.equals(STOPPER)) {
				break;
			}
			lines.addElement(line);
		}
		System.out.print("Number of lines: ");
		System.out.println(lines.size());
		System.out.print("Middle line: ");
		System.out.println((String) lines.elementAt(lines.size()/ 2));

		// continued on next slide...
		// continued from previous slide

		// Print the lines in reverse order
		System.out.println("Lines in reverse order:");
		for (int i = lines.size() - 1; i >= 0; i--) {
			System.out.println((String) lines.elementAt(i));
		}
	}
}