package library;

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
	public BookNode getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	void setNext(BookNode next) {
		this.next = next;
	}

}
