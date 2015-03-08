package library;

public final class Library {

	private final BookList bookList;
	private final PersonList personList;
	
	public Library() {
		bookList = new BookList(); 
		personList = new PersonList(); 
	} 
	
	public void insertBook(String name, String location) {
		bookList.insertBook(name, location);
	}

	public void insertPerson(String firstName, String lastName, String address) {
		personList.insertPerson(firstName, lastName, address);
	}	
	
	public boolean containsBook(String name) {
		return bookList.lookup(name) != null; 
	}
	
	public BookNode[] getBookNodeTitleArray(String title) {
		return bookList.lookup(title); 
	}
	
	public BookNode[] getBookNodePersonArray(int idPerson) {
		return bookList.onePersonBorrowedList(idPerson); 
	}
	
	public PersonNode getPersonNode(int id){
		return personList.lookup(id);		
	}
	
	public boolean lendBook(int idPerson, String title){
		return bookList.lendBook(getPersonNode(idPerson).getPerson(), title);
	}
	
	public boolean lendBook(int idPerson, int idBook){
		return bookList.lendBook(getPersonNode(idPerson).getPerson(), idBook);
	}
	
	public boolean givebackBook(String title){
		return bookList.givebackBook(title);
	}
	
	public boolean givebackBook(int idBook){
		return bookList.givebackBook(idBook);
	}
	
	public BookNode[] overdue(){
		return bookList.overdue();
	}
	
	public PersonNode[] getPersonArray(){
		return personList.getPersonArray();
	}
	
	public BookNode[] getBookArray(){
		return bookList.getBookArray();
	}
	
}
