package test;

import java.util.function.Function;

import inout.In;
import inout.Out;
import inout.Window;
import first.Branch;
import first.Transform;
import first.Source;
import first.Sink;
import first.Branch;

//import first.Filter;

public class DrawingApp {

	public static void main(String[] args) {
		
		
		Source<String> input = new Source<String>(() -> {
			Out.print("Input new float value: ");
			return In.readLine();
		}, f -> {
			Out.println(" -> input: value " + f + " sent!");
		});

		Branch<String> command = new Branch<String>(
				f -> {
					Out.println(" -> scale10: value " + f + " received!");
				}, f -> f.substring(0,3).equals("rect")	,
				f -> {
			Out.println(" -> input: value " + f + " sent!");
		});

		input.setNext(command);
		
		command.SetLeftRight(displayRectangle, displayCircle);

		// input.setNext(...);

		// --- start processing ---

		Window.clear();

		while (true) {
			input.generate();
		}

	}
}
