package patterns.visitor;

interface Visitor<T> {
	T visitBody(Body b);

	T visitWheel(Wheel w);

	T visitEngine(Engine e);

	T visitCar(Car c);
}

class WeightVisitor implements Visitor<Integer> {

	@Override
	public Integer visitBody(Body b) {
		return b.getWeight();
	}

	@Override
	public Integer visitWheel(Wheel w) {
		return w.getWeight();
	}

	@Override
	public Integer visitEngine(Engine e) {
		return e.getWeight();
	}

	@Override
	public Integer visitCar(Car c) {
		int body = c.body.accept(this);
		int engine = c.engine.accept(this);
		int wheels = 0;
		for (Wheel w : c.wheels) {
			wheels += w.accept(this);
		}
		return body + engine + wheels;
	}

}

public class VisitorDemo {
	static public void main(String[] args) {
		Car car = new Car();

		Visitor<Integer> drawVisitor = new WeightVisitor();
		System.out.println(car.accept(drawVisitor));
	}
}
