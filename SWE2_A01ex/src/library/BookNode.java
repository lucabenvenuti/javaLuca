package library;

/**
 * @author luca
 * BookNode class to store an object book and the next BookNode object
 */
public final class BookNode {
	
	private Book book;
	private BookNode next;
	/**
	 * @param book
	 * @param next
	 */
	BookNode(Book book, BookNode next) {
		this.setBook(book);
		this.setNext(next);
	}
	
	/**
	 * @param book
	 */
	BookNode(Book book){
		this(book, null);
	}
	
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @return the next
	 */
	BookNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	void setNext(BookNode next) {
		this.next = next;
	}

}
