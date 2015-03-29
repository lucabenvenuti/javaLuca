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
	/*	input.generate();
		input.getOnSend();
		input.getGenerator();*/
		
		Transform<Float, Float> input2 = new Transform<Float, Float>(
				input.??, 
				multiply,
				multiplied -> {
					Out.println(" -> scale10: value " + multiplied + " sent!");
				}
				);
		
	//	input2.multiply();
		
	/*	Transform<Float, Float> trimmer = new Transform<Float, Float>(() -> {
			Out.print("Input new aafloat value: ");
			return In.readFloat();
		}, a -> {
			Out.println(" -> input: value " + a + " sent!");
			return a;
		}, null);
		
		System.out.println(trimmer);*/
		
		//Scale10 <Float, Float> scale10 = input -> input.multiply10();

		// TODO

		// input.setNext(...);

		// --- start processing ---

//		Window.clear();
	/*	while (true) {
			
		}*/
	}
}
