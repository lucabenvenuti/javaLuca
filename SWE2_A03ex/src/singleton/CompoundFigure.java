package singleton;

//import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


//import singleton.FigureList.CompoundFigure;
import inout.Window;



public class CompoundFigure extends Figure{
	
	FigureList figureList = new FigureList();

	protected CompoundFigure(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {
		// TODO Auto-generated method stub
		
	}
	
	void add(Figure f){
		figureList.push(f);
	/*	if (!figureList.isEmpty()){
			Iterator<Figure> it = figureList.iterator();
			while (it.hasNext()) {}
		//	figureList.
		}*/
	}
	
	void removeListHead(){
		figureList.pop();
	}
	
	void getListHead(){
		figureList.top();
	}
	
	private static class Node {

		Figure figure;
		Node next;

		Node(Figure figure, Node next) {
			this.figure = figure;
			this.next = next;
		}

	}
	
	private static class FigureList implements Iterable<Figure> {
			
			private Node head;
			
			public void push(Figure val) {
				head = new Node(val, head);
			}

			public void pop() throws NoSuchElementException {
				if (isEmpty())
					throw new NoSuchElementException();
				head = head.next;
			}
			
			public Figure top() throws NoSuchElementException {
				if (isEmpty())
					throw new NoSuchElementException();
				return head.figure;
			}

			public boolean isEmpty() {
				return head == null;
			}

			@Override
			public Iterator<Figure> iterator() {

				return new Iterator<Figure>() {

					Node current;

					{
						current = head;
					}

					@Override
					public boolean hasNext() {
						return current != null;
					}

					@Override
					public Figure next() throws NoSuchElementException {
						if (current == null)
							throw new NoSuchElementException();
						Figure val = current.figure;
						current = current.next;
						return val;
					}

				};
			}

			
			}
	
}


	