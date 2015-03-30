package test;

import java.util.function.Function;

import second.Source;
import inout.In;
import inout.Out;
import inout.Window;
import figures.Rectangle;
import figures.Circle;
import first.Branch;
import first.Filter;
import first.Transform;
import first.Sink;

public class DrawingApp {

	public static void main(String[] args) {

		Source<String> command = new Source<String>(() -> {
			Out.print("Input command: ");
			return In.readLine();
		}, f -> {
			Out.println(" -> command: sent " + f);
		});

		Branch<String> branchRect = new Branch<String>(f -> {
			Out.println(" -> branchRect: received " + f);
		}, f -> f.substring(0, 4).equals("rect"), f -> {
			Out.println(" -> branchRect: sent " + f);
		});

		Function<String, Rectangle> rectCreator = new Function<String, Rectangle>() {
			
			@Override
			public Rectangle apply(String i) {
				
				String[] parts = i.split(" ");
				
				int x = Integer.parseInt(parts[1]);
				int y = Integer.parseInt(parts[2]);
				int w = Integer.parseInt(parts[3]);
				int h = Integer.parseInt(parts[4]);
				return new Rectangle(x, y, w, h);
			}

		};

		Function<String, Circle> circleCreator = new Function<String, Circle>() {

			@Override
			public Circle apply(String i) {
				String[] parts = i.split(" ");
				
				int x = Integer.parseInt(parts[1]);
				int y = Integer.parseInt(parts[2]);
				int r = Integer.parseInt(parts[3]);
				return new Circle(x, y, r);
			}

		};

		Transform<String, Rectangle> createRect = new Transform<String, Rectangle>(
				rectCreator, f -> {
					Out.println(" -> createRect: received " + f);
				}, f -> {
					Out.println(" -> createRect: sent " + f.toString());
				});

		Branch<String> branchCircle = new Branch<String>(f -> {
			Out.println(" -> branchCircle: received " + f);
		}, f -> f.substring(0, 6).equals("circle"), f -> {
			Out.println(" -> branchCircle: sent " + f);
		});

		Transform<String, Circle> createCircle = new Transform<String, Circle>(
				circleCreator, f -> {
					Out.println(" -> createCircle: received " + f);
				}, f -> {
					Out.println(" -> createCircle: sent " + f.toString());
				});

		Sink<String> displayError = new Sink<String>(f -> {
			Out.println(" -> not a rectangle nor a circle!");
		});

		Filter<Rectangle> filterNullRect = new Filter<Rectangle>(f -> {
			Out.println(" -> filterNullRect: received " + f.toString());
		}, f -> f != null, f -> {
			Out.println(" -> filterNullRect: sent " + f.toString());
		});

		Filter<Circle> filterNullCircle = new Filter<Circle>(f -> {
			Out.println(" -> filterNullCircle: received " + f.toString());
		}, f -> f != null, f -> {
			Out.println(" -> filterNullCircle: sent " + f.toString());
		});

		Sink<Rectangle> displayRect = new Sink<Rectangle>(f -> f.draw(100, 100));

		Sink<Circle> displayCircle = new Sink<Circle>(f -> f.draw(200, 100));

		command.setNext(branchRect);

		branchRect.SetLeftRight(createRect, branchCircle);

		branchCircle.SetLeftRight(createCircle, displayError);

		createRect.setNext(filterNullRect);

		createCircle.setNext(filterNullCircle);

		filterNullRect.setNext(displayRect);

		filterNullCircle.setNext(displayCircle);

		Window.clear();

		while (true) {
			command.generate();
		}

	}
}
