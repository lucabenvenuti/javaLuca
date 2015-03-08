package library;

import java.util.Calendar;

final class LendingNode {

	private Book book;
	private Person person;
	private Calendar cal;
	private LendingNode next;
	
	LendingNode(Book book, Person person, int days) {
	/*	this.setBook(book);
		this.setPerson(person);
		this.setCal(days); */
		this(book, person, days, null);
	}
	
	LendingNode(Book book, Person person, int days, LendingNode next) {
		this.setBook(book);
		this.setPerson(person);
		this.setCal(days);
		this.setNext(next);
	}
	
	
	
	void setCal(int days) {
		this.cal = Calendar.getInstance();
		this.cal.add(Calendar.DATE,days);
	}


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
	 * @return the next
	 */
	LendingNode getNext() {
		return next;
	}


	/**
	 * @param next the next to set
	 */
	void setNext(LendingNode next) {
		this.next = next;
	}
	
	
}
