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
					Out.println(" -> scale10: value " + f + " received!");
				}, 
				f -> f.floatValue()*10,
				f -> {
					Out.println(" -> scale10: value " + f + " sent!");
				}
				);

		float[] arrayFloat2 = new float[]{10,11,12,13,14,88,87,85,96};
		int k=Math.min(arrayFloat2.length, 5);
		int j=0;
		float[] arrayFloat = new float[k];
		for(int i = 0; i < arrayFloat.length ;i++)
		{arrayFloat[i] =arrayFloat2[arrayFloat2.length-j];
		j++;} 

		input.generate();
		scale10.transformation((float) 10);



		Transform<Float, Float> average5 = new Transform<Float, Float>(
				f -> {
					Out.println(" -> input: value " + f + " received!");
				}, 
				f -> f.apply(),
				f -> {
					Out.println(" -> scale10: value " + f + " sent!");
				}
				){
			{
				private float sum = 0;

				public float apply(float f) {
					sum += f;
					return sum; 
				} 
			}
		};

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




		// TODO

		// input.setNext(...);

		// --- start processing ---

		//		Window.clear();
		/*	while (true) {

		}*/
	}
}
