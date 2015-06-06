package mdraw.shapes;

interface Visitor<T> {
	T visitShape(Shape s);
}
