package patterns.visitor;

class Wheel {

	private String name;
	private final int weight = 1;

	Wheel(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	String getName() {
		return this.name;
	}

	<T> T accept(Visitor<T> v) {
		return v.visitWheel(this);
	}

}

class Engine {

	private final int weight = 5;

	public int getWeight() {
		return weight;
	}

	<T> T accept(Visitor<T> v) {
		return v.visitEngine(this);
	}

}

class Body {

	private final int weight = 6;

	public int getWeight() {
		return weight;
	}

	<T> T accept(Visitor<T> v) {
		return v.visitBody(this);
	}

}

public class Car {
	Engine engine = new Engine();
	Body body = new Body();
	Wheel[] wheels = { new Wheel("front left"), new Wheel("front right"),
			new Wheel("back left"), new Wheel("back right") };

	<T> T accept(Visitor<T> v) {
		return v.visitCar(this);
	}

}
