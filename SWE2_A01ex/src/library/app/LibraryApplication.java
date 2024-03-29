package library.app;

import library.BookNode;
import library.Library;
import library.Book;
import library.Person;
import library.PersonNode;
import inout.In;
import inout.Out;


/**
 LibraryApplication.java
 *
 * A {@link LibraryApplication} which implements the main
 * application for the library with the user dialog.
 * 
 * Software Development II, 2015SS
 * JKU Linz
 * 
 * @author Luca Benvenuti
 */
public class LibraryApplication {

  /**
   * Main method starting the application.
   * 
   * @param args
   */
  public static void main(String[] args) {
	  
	  Library lucaLibrary = new Library();
	  lucaLibrary.insertBook("LOTR", "Fantasy shelf");
	  lucaLibrary.insertBook("The Great Gatsy", "American Literature shelf");
	  lucaLibrary.insertBook("The Wheel of Time", "Fantasy shelf");
	  lucaLibrary.insertBook("On the road", "American Literature shelf");	
	  
	  lucaLibrary.insertPerson("Luca","Benvenuti", "Julius Raab 10, Linz");
	  lucaLibrary.insertPerson("John","Smith", "Altenbergerstrasse 50, Linz");
	  lucaLibrary.insertPerson("Jane","Doe", "Linzerstrasse 30, Freidstadt");
	  
	  String s01 = "  a - insert book ";
	  String s02 = "  b - insert user ";
	  String s03 = "  c - check book existence ";
	  String s04 = "  d - given a keyword, show all books with it in the title ";
      String s05 = "  e - show all lendings of one person ";		
      String s06 = "  f - lend a book ";
      String s07 = "  g - give a book back ";
      String s08 = "  h - show all books by ID number ";
      String s09 = "  i - show all users by ID number ";
      String s10 = "  l - show all overdued books ";
      String s11 = "  n - ask if a book is lended ";

	    Out.println("Library ");
	    Out.println("=========== ");
	    Out.println("Please select the desidered function: ");
	    Out.println(s01);
	    Out.println(s02);
	    Out.println(s03);
	    Out.println(s04);
	    Out.println(s05);
	    Out.println(s06);
	    Out.println(s07);
	    Out.println(s08);
	    Out.println(s09);
	    Out.println(s10);
	    Out.println(s11);
	    Out.println("  q - quit: Program quit ");

	    // Read operation code and perform operation
	    char op = readOperation();
	    while (op != 'q') {
	      switch (op) {
	      case 'a': // insert new book
	    	Out.println(s01);
	        Out.print("   Please write the title into apexes (\"\"): ");
	        String name = In.readString();
	        Out.print("   Please write the location into apexes (\"\"): ");
	        String location = In.readString();
	        Out.println("   Successfully inserted book: ");
	        printBookNode(lucaLibrary.insertBook(name, location));
	        break;
	      case 'b': // insert new user
	    	    Out.println(s02);
		        Out.print("   Please write the first name: ");
		        String firstName = In.readWord();
		        Out.print("   Please write the last name: ");
		        String lastName = In.readWord();
		        Out.print("   Please write the address into apexes (\"\"): ");
		        String address = In.readString();
		        Out.println("   Successfully inserted person: ");
		        printPersonNode(lucaLibrary.insertPerson(firstName, lastName, address));
		        break;    
	      case 'c': // check book existence
	    	    Out.println(s03);
		        Out.print("   Please write the title into apexes (\"\") the title to check existence: ");
		        name = In.readString();
		        printBookExistence(name, lucaLibrary.containsBook(name));
		        break;    
	      case 'd': // given a keyword, show all books with it in the title
	    	    Out.println(s04);
		        Out.print("   Please write the title into apexes (\"\") to show all compatible books: ");
		        name = In.readString();
		        Out.println("   The compatible books with the keyword \"" + name + "\" are: ");
		        printBookArray(lucaLibrary.getBookNodeTitleArray(name));
		        break;    
	      case 'e': // show all lendings of one person
	    	    Out.println(s05);
		        Out.print("   Please write the person's ID to show all his/her lending: ");
		        int id = In.readInt();
		        Out.println("   The books borrowed by user \"" + id + "\" are: ");
		        printBookArray(lucaLibrary.getBookNodePersonArray(id));
		        break;        
	      case 'f': // lend a book
	    	    Out.println(s06);
		        Out.print("   Please write the person's ID to lend: ");
		        int idPerson = In.readInt();
		        Out.print("   Please write the book's ID to lend: ");
		        int idBook = In.readInt();
		        switch(lucaLibrary.lendBook(idPerson, idBook)){
		        	case 0: Out.println("   Lending failed. ");; break;
		        	case 1: Out.println("   The lending have been extended for " + Book.DAYS_EXTENDED_LOAN + " more days. "); break;
		        	case 2: Out.println("   The lending have been granted for " + Book.DAYS_FIRST_LOAN + " days. "); break;
		        }
		        break;     
	      case 'g': // give a book back
	    	    Out.println(s07);
		        Out.print("   Please write a book's ID to give it back: ");
		        idBook = In.readInt();
		        if(lucaLibrary.givebackBook(idBook)){
		        	Out.println("   The book has been successfully given back. ");
		        } else {
		        	Out.println("   The restitution has failed. Try again. ");
		        }
		        break;   
	      case 'h': // show all books by ID number
	    	    Out.println(s08);
		        Out.print("   show all books by ID number: ");
		        printBookArray(lucaLibrary.getBookArray());
		        break;  
	      case 'i': // show all users by ID number
	    	    Out.println(s09);
		        Out.print("   show all users by ID number: ");
		        printPersonArray(lucaLibrary.getPersonArray());
		        break;  
	      case 'l': // show all overdued books
	    	    Out.println(s10);
		        Out.print("   List of all overdued books: ");
		        printBookArray(lucaLibrary.overdue());
		        break;  
	      case 'n': // ask if a book is lended
	    	    Out.println(s11);
		        Out.print("   Please write the book's ID to check availability: ");
		        idBook = In.readInt();
		        switch(lucaLibrary.available(idBook)){
		        case 0: Out.print("   The book does not exist. "); break;
		        case 1: Out.print("   The book is lended. ");break;
		        case 2: Out.print("   The book is not lended. ");break;}
		        break;  
	      }
	      op = readOperation();
	    }
	    Out.println();
	    Out.println("Ciao! Leave the library program!");
	  
  }// main


/**
   * Reads in the operation character.
   * 
   * @return the character specifying the next operation.
   */
  private static char readOperation() {
    Out.println();
    Out.print("Please select the operation: (a,b,c,d,e,f,g,h,i,l,n,q): ");

    char op = In.readChar();
    while (op != 'a' && op != 'b' && op != 'c' && op != 'd' && op != 'e'
    		&& op != 'f' && op != 'g' && op != 'h' && op != 'i' && op != 'l' && op != 'n'
            && op != 'q') {
      // wrong operation code, repeat input of operation code
      Out.println();
      Out.print("   Wrong input! Please select the operation once more: (a,b,c,d,e,f,g,h,i,l,n,q): ");
      op = In.readChar();
    }
    return op;
  } // readOperation

  /**
   * Print out the book.
   * 
   * @param b
   *          the Book
   */
  private static void printBook(Book b) {
    if (b != null) {
      Out.println("--> " + b.toString());
    } else {
      Out.println("--> " + "--");
    }
  } // writeEntry
  
  /**
   * Print out the bookNode.
   * 
   * @param bookNode
   */
  private static void printBookNode(BookNode bookNode) {
	  printBook(bookNode.getBook());	
	}

  
  /**
   * Print out the BookNode objects array.
   * @param b
   */
  private static void printBookArray(BookNode[] b) {
	  Out.println("");
	  if (b==null || b.length==0){
		  Out.println("   There are no books with the requested query.");
	  }else{
	  	for(int i=0; i<b.length;i++){
	  		printBook(b[i].getBook());
	  		}
	  	Out.println("");}
	  } 
  
   /**
    * Print out the PersonNode objects array.
    * @param p
  	*/
  private static void printPersonArray(PersonNode[] p) {
	  Out.println("");
	  if (p==null || p.length==0){
		  Out.println("   There are no persons with the requested query.");
	  }else{
	  	for(int i=0; i<p.length;i++){
	  		printPerson(p[i].getPerson());
	  	}
	  	Out.println("");}
	  } // writeEntry
  
  
  /**
   * Print out the Person p.
   * 
   * @param p
   */
  private static void printPerson(Person p) {
	    if (p != null) {
	      Out.println("--> " + p.toString());
	    } else {
	      Out.println("--> " + "--");
	    }
	  } // writeEntry

  /**
   * Print out the PersonNode p.
   * 
   * @param personNode
   */  
  private static void printPersonNode(PersonNode personNode) {
	  printPerson(personNode.getPerson());	
  }
  
  /**
   * Print out the existence of a book.
   * 
   * @param name
   * @param containsBook
   */
  private static void printBookExistence(String name, boolean containsBook) {
	  if (containsBook){
		  Out.println("The book \"" + name + "\" exists.");
	  } else {
		  Out.println("The book \"" + name + "\" never belonged to the library.");
	  }
	}
  
  }