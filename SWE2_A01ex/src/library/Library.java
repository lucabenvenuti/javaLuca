package library;

public final class Library {

	private final BookList bookList;
	private final PersonList personList;
	
	public Library() {
		bookList = new BookList(); 
		personList = new PersonList(); 
	} 
	
	public BookNode insertBook(String name, String location) {
		return bookList.insertBook(name, location);
	}

	public PersonNode insertPerson(String firstName, String lastName, String address) {
		return personList.insertPerson(firstName, lastName, address);
	}	
	
	public boolean containsBook(String name) {
		return bookList.lookup(name) != null; 
	}
	
	public BookNode[] getBookNodeTitleArray(String title) {
		return (bookList.lookup(title)==null? null:bookList.lookup(title)); 
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
	
	public int lendBook(int idPerson, int idBook){
		PersonNode personNode  = getPersonNode(idPerson);
		if(personNode==null){
			return 0;
		}else{
		return bookList.lendBook(personNode.getPerson(), idBook);}
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

	public boolean available(int idBook) {
		return bookList.available(idBook);
	}
	
}
