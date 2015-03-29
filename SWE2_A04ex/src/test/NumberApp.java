package test;

import inout.In;
import inout.Out;
import inout.Window;
import first.Transform;
import first.Source;
//import first.Transformer;

public class NumberApp {

	public static void main(String[] args) {

		Source<Float> input = new Source<Float>(() -> {
			Out.print("Input new float value: ");
			return In.readFloat();
		}, f -> {
			Out.println(" -> input: value " + f + " sent!");
		});
		
		


		
		Transform<Float, Float> scale10 = new Transform<Float, Float>(
				f -> {
					Out.println(" -> input: value " + f + " received!");
				}, 
				f -> f.floatValue()*10,
				f -> {
					Out.println(" -> scale10: value " + f + " sent!");
				}
				);
		
		Transform<Float, Float> average5 = new Transform<Float, Float>(
				f -> {
					Out.println(" -> input: value " + f + " received!");
				}, 
				f -> f.floatValue()*10,
				f -> {
					Out.println(" -> scale10: value " + f + " sent!");
				}
				);

		Transform<Float, Float> round = new Transform<Float, Float>(
				f -> {
					Out.println(" -> input: value " + f + " received!");
				}, 
				f -> f.floatValue()*10,
				f -> {
					Out.println(" -> scale10: value " + f + " sent!");
				}
				);
		
		Sink<Float> displayer = new Sink<Float>(
				f -> {
					Out.println(" -> input: value " + f + " received!");
				}	
			,f -> {
			Out.println(" -> scale10: value " + f + " sent!");
		});
		
		input.generate();
		scale10.multiply((float) 10);
	

		// TODO

		// input.setNext(...);

		// --- start processing ---

//		Window.clear();
	/*	while (true) {
			
		}*/
	}
}
