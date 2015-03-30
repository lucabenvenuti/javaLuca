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
		
		
		Source<String> command = new Source<String>(() -> {
			Out.print("Input new float value: ");
			return In.readLine();
		}, f -> {
			Out.println(" -> input: value " + f + " sent!");
		});

		Branch<String> branchRect = new Branch<String>(
				f -> {
					Out.println(" -> scale10: value " + f + " received!");
				}, f -> f.substring(0,3).equals("rect")	,
				f -> {
			Out.println(" -> input: value " + f + " sent!");
		});
		
		Transform<String, Rectangle> round = new Transform<String, Rectangle>(
				rounder, f -> {
					Out.println(" -> round: value " + f + " received!");
				}, f -> {
					Out.println(" -> round: value " + f + " sent!");
				});
		
		Branch<String> branchCircle = new Branch<String>(
				f -> {
					Out.println(" -> scale10: value " + f + " received!");
				}, f -> f.substring(0,3).equals("circ")	,
				f -> {
			Out.println(" -> input: value " + f + " sent!");
		});

		command.setNext(branchRect);
		
		branchRect.SetLeftRight(createRect, branchCircle);

		// input.setNext(...);

		// --- start processing ---

		Window.clear();

		while (true) {
			input.generate();
		}

	}
}
