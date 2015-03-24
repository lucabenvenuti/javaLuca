package figures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CompoundFigure extends Figure{

	FigureList figureList = new FigureList();
	
	public CompoundFigure(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(int xOrigin, int yOrigin) {
		for (Figure f:figureList){
			f.draw(xOrigin+x, yOrigin+y);
		}
	}
	
	public void add(Figure f){
		figureList.push(f);
	}
	
	public void removeListHead(){
		figureList.pop();
	}
	
	public void getListHead(){
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

					Node current = head;

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

					@Override
					public void remove() {
						current = current.next;
					}

				};
			}
		}
	
}


	