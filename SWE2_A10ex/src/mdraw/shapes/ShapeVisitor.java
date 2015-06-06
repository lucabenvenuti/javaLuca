package mdraw.shapes;

public interface ShapeVisitor<T> {
	public T visitRect(Rect r);
	public T visitOval(Oval o);
	public T visitGroup(Group g);
	public T visitAdapter(ImageAdapter a);
}
