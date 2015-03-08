package library;

import java.util.Calendar;
//import java.util.Date;

/**
 * @author luca
 * BookNode or lending
 */
final class BookNodeOLD {
	
	private Book book;
	private Person person;
	private Calendar cal;
	
	private BookNodeOLD next;

	/**
	 * @return the book
	 */
	Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the person
	 */
	Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the cal
	 */
	Calendar getCal() {
		return cal;
	}

	/**
	 * @param cal the cal to set
	 */
	void setCal(int days) {
		this.cal = Calendar.getInstance();
		this.cal.add(Calendar.DATE,days);
	}

	/**
	 * @return the next
	 */
	BookNodeOLD getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	void setNext(BookNodeOLD next) {
		this.next = next;
	}

	/**
	 * @param book
	 * @param person
	 * @param cal
	 * @param next
	 */
	BookNodeOLD(Book book, Person person, int days, BookNodeOLD next) {
		this.setBook(book);
		this.setPerson(person);
		this.setCal(days);
		this.setNext(next);
	}

	
}

