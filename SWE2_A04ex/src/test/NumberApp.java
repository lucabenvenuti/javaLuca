package test;

import java.util.function.Function;

import second.Source;
import inout.In;
import inout.Out;
import inout.Window;
import first.Transform;
import first.Sink;

/**
 * NumberApp.java
 *
 * A {@link NumberApp} is a test class; asks float numbers and averages them.
 * Finally, it draws a rectangle as high as the average.
 * 
 * Software Development II, 2015SS JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class NumberApp {

	public static void main(String[] args) {

		Source<Float> input = new Source<Float>(() -> {
			Out.print("Input new float value: ");
			return In.readFloat();
		}, f -> {
			Out.println(" -> input: value " + f + " sent!");
		});

		Transform<Float, Float> scale10 = new Transform<Float, Float>(
				f -> f.floatValue() * 10, f -> {
					Out.println(" -> scale10: value " + f + " received!");
				}, f -> {
					Out.println(" -> scale10: value " + f + " sent!");
				});

		Function<Float, Float> averager = new Function<Float, Float>() {
			private float array[] = new float[5];
			private int j = 0, counter = 0;

			/**
			 * (non-Javadoc)
			 * 
			 * @see java.util.function.Function#apply(java.lang.Object)
			 * 
			 *      add the float to the array and return the average of the
			 *      array element
			 * 
			 */
			@Override
			public Float apply(Float i) {
				if (j == 5) {
					j = 0;
				}
				array[j] = i;
				j++;
				counter++;
				float sum = 0;
				if (counter < 5) {
					for (int k = 0; k < j; k++) {
						sum += array[k];
					}
					return sum / counter;
				} else {
					for (int k = 0; k < 5; k++) {
						sum += array[k];
					}
					return sum / 5;
				}
			}

		};

		Transform<Float, Float> average5 = new Transform<Float, Float>(
				averager, f -> {
					Out.println(" -> average5: value " + f + " received!");
				}, f -> {
					Out.println(" -> average5: value " + f + " sent!");
				});

		Transform<Float, Integer> round = new Transform<Float, Integer>(
				f -> f.intValue(), f -> {
					Out.println(" -> round: value " + f + " received!");
				}, f -> {
					Out.println(" -> round: value " + f + " sent!");
				});

		Sink<Integer> display = new Sink<Integer>(f -> {
			Window.drawRectangle(10, 10, 10, f);
			Out.println(" -> display: value " + f + ".0 received!");
		});

		input.setNext(scale10);
		scale10.setNext(average5);
		average5.setNext(round);
		round.setNext(display);

		Window.clear();

		while (true) {
			input.generate();
		}

	}
}
