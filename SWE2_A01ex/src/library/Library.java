package library;

/**
 * Library.java
 *
 * A {@link Library} is a class which 
 * store an object {@link BookList} 
 * and an object {@link PersonList}, 
 * and allows a series of operation
 * over them.
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public final class Library {

	private final BookList bookList;
	private final PersonList personList;
	
	/**
	 * Empty constructor for the Library class
	 */
	public Library() {
		bookList = new BookList(); 
		personList = new PersonList(); 
	} 
	
	/**
	 * Insert a book in the library
	 * @param name
	 * @param location
	 * @return the BookNode where the Book is inserted
	 */
	public BookNode insertBook(String name, String location) {
		return bookList.insertBook(name, location);
	}

	/**
	 * Insert a person as library user
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @return the PersonNode where the Person is inserted
	 */
	public PersonNode insertPerson(String firstName, String lastName, String address) {
		
		if (personList.isFirstLastName(firstName,lastName)){
			PersonNode personNode = getPersonNode(firstName,lastName);
			personNode.getPerson().setAddress(address);
			return personNode;
		}
		return personList.insertPerson(firstName, lastName, address);
	}	
	


	/**
	 * Check if a book is inside the BookList
	 * @param name
	 * @return true if there is one or more book with name inside the title, false otherwise
	 */
	public boolean containsBook(String name) {
		return bookList.lookup(name) != null; 
	}
	
	/**
	 * Obtain an array of BookNode object given a title keyword
	 * @param title
	 * @return null if there is no object, a BookNode array otherwise
	 */
	public BookNode[] getBookNodeTitleArray(String title) {
		return (bookList.lookup(title)==null? null:bookList.lookup(title)); 
	}
	
	/**
	 * Obtain an array of BookNode object given the ID of a user
	 * @param idPerson
	 * @return BookNode array
	 */
	public BookNode[] getBookNodePersonArray(int idPerson) {
		return bookList.onePersonBorrowedList(idPerson); 
	}
	
	/**
	 * Obtain a PersonNode object given a user ID
	 * @param id
	 * @return PersonNode object
	 */
	public PersonNode getPersonNode(int id){
		return personList.lookup(id);		
	}
	
	/**
	 * get a PersonNode given this firstName and lastName
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	private PersonNode getPersonNode(String firstName, String lastName) {
		return personList.lookup(firstName, lastName);
	}
	
	/**
	 * DEPRECATED: please use 
	 * "public int lendBook(int idPerson, int idBook)"
	 * Perform the book lending
	 * @param idPerson
	 * @param title
	 * @return true if a book is correctly lended, false otherwise
	 */
	public boolean lendBook(int idPerson, String title){
		return bookList.lendBook(getPersonNode(idPerson).getPerson(), title);
	}
	
	/**
	 * Perform the book lending
	 * @param idPerson
	 * @param idBook
	 * @return true if a book is correctly lended, false otherwise
	 */
	public int lendBook(int idPerson, int idBook){
		PersonNode personNode  = getPersonNode(idPerson);
		if(personNode==null){
			return 0;
		}else{
		return bookList.lendBook(personNode.getPerson(), idBook);}
	}
	
	/**
	 * DEPRECATED: please use 
	 * "public boolean givebackBook(int idBook)"
	 * Give back a book
	 * @param title
	 * @return true if a book is correctly given back, false otherwise
	 */
	public boolean givebackBook(String title){
		return bookList.givebackBook(title);
	}
	
	/**
	 * Give back a book
	 * @param idBook
	 * @return true if a book is correctly given back, false otherwise
	 */
	public boolean givebackBook(int idBook){
		return bookList.givebackBook(idBook);
	}
	
	/**
	 * @return the BookNode objects array which Books have restitution dates later than today
	 */
	public BookNode[] overdue(){
		return bookList.overdue();
	}
	
	/**
	 * @return all the PersonNode objects stored in the 
	 * PersonList object of this object as PersonNode array
	 */
	public PersonNode[] getPersonArray(){
		return personList.getPersonArray();
	}
	
	/**
	 * @return all the BookNode objects stored in the 
	 * BookList object of this object as BookNode array
	 */
	public BookNode[] getBookArray(){
		return bookList.getBookArray();
	}

	/**
	 * Check the availability of a book
	 * @param idBook
	 * @return given a book ID, 
	 * 0 if it does not exist, 1 if it is lended, 2 if it is not lended.
	 */
	public int available(int idBook) {
		return bookList.available(idBook);
	}
	
}
