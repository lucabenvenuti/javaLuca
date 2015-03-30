package test;

import java.util.function.Function;

import inout.In;
import inout.Out;
import inout.Window;
import first.Transform;
import first.Source;
import first.Sink;

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

		Function<Float, Integer> rounder = new Function<Float, Integer>() {

			@Override
			public Integer apply(Float i) {
				int j = Math.round(i);
				return j;
			}

		};

		Function<Float, Float> averager = new Function<Float, Float>() {
			private float array[] = new float[5];
			private int j = 0, counter = 0;
			private float sum;

			@Override
			public Float apply(Float i) {
				if (j == 5) {
					j = 0;
				}
				array[j] = i;
				j++;
				counter++;

				if (counter < 5) {
					sum = 0;
					for (int k = 0; k < j; k++) {
						sum += array[k];
					}
					return sum / counter;
				} else {
					sum = 0;
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
				rounder, f -> {
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
