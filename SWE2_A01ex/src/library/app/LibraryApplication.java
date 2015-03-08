package library.app;

import library.BookNode;
import library.Library;
import library.Book;
import library.Person;
import inout.In;
import inout.Out;


/**
 * Implements the main application for the phone book with the user dialog
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
	  
	    // Put out operations
	    Out.println("Telefonbuch ");
	    Out.println("=========== ");
	    Out.println("Folgende Operationen stehen zur Verfügung: ");
	    Out.println("  a - insert book ");
	    Out.println("  b - insert user ");
	    Out.println("  c - check book availability ");
	    Out.println("  d - given a keyword, show all books with it in the title ");
	    Out.println("  e - show all lendings of one person ");
	    Out.println("  f - lend a book ");
	    Out.println("  g - give a book back ");
	    Out.println("  h - show all books by ID number ");
	    Out.println("  i - show all users by ID number ");
	    Out.println("  l - show all overdued books ");
	    Out.println("  q - quit: Programm verlassen");

	    // Read operation code and perform operation
	    char op = readOperation();
	    while (op != 'q') {
	      switch (op) {
	      case 'a': // insert new entry
	        Out.print("   Please write the title: ");
	        String name = In.readWord();
	        Out.print("   Please write the location: ");
	        String location = In.readWord();
	        lucaLibrary.insertBook(name, location);
	        break;
	      case 'b': // insert new entry
		        Out.print("   Please write the first name: ");
		        String firstName = In.readWord();
		        Out.print("   Please write the last name: ");
		        String lastName = In.readWord();
		        Out.print("   Please write the address: ");
		        String address = In.readWord();
		        lucaLibrary.insertPerson(firstName, lastName, address);
		        break;    
	      case 'c': // insert new entry
		        Out.print("   Please write the title to check availability: ");
		        name = In.readWord();
		        Out.print(lucaLibrary.containsBook(name));
		        break;    
	      case 'd': // insert new entry
		        Out.print("   Please write the title to show all compatible books: ");
		        name = In.readWord();
		        printBookArray(lucaLibrary.getBookNodeTitleArray(name));
		        break;    
	      case 'e': // insert new entry
		        Out.print("   Please write the person's ID to show all his/her lending: ");
		        int id = In.readInt();
		        printBookArray(lucaLibrary.getBookNodePersonArray(id));
		        break;        
	      case 'f': // insert new entry
		        Out.print("   Please write the person's ID and a book's ID to lend: ");
		        int idPerson = In.readInt();
		        int idBook = In.readInt();
		        Out.print(lucaLibrary.lendBook(idPerson, idBook));
		        break;     

	      }
	      op = readOperation();
	    }

	    

	    Out.println();
	    Out.println("Ciao! Auf ein Wiedersehen freut sich Dein Telefonbuch!");
	  
  }// main

  /**
   * Reads in the operation character.
   * 
   * @return the character specifying the next operation.
   */
  private static char readOperation() {
    Out.println();
    Out.print("Bitte Operation auswaehlen: (a,b,c,d,e,f,g,h,i, l, q): ");

    char op = In.readChar();
    while (op != 'a' && op != 'b' && op != 'c' && op != 'd' && op != 'e'
    		&& op != 'f' && op != 'g' && op != 'h' && op != 'i' && op != 'l'
            && op != 'q') {
      // wrong operation code, repeat input of operation code
      Out.println();
      Out.print("   Falsche Eingabe! Bitte Eingabe wiederholen: (a,b,c,d,e,f,g,h,i,l, q): ");
      op = In.readChar();
    }
    return op;
  } // readOperation

  /**
   * Print out the entry.
   * 
   * @param e
   *          the entry
   */
  private static void printBook(Book b) {
    if (b != null) {
      Out.println("--> " + b.toString());
    } else {
      Out.println("--> " + "--");
    }
  } // writeEntry
  
 /* public boolean test1(BookNode[] b){
	  b[0].
	  return false;
  }*/
  
  public static void printBookArray(BookNode[] b) {
	//  b[i].
	  	for(int i=0; i<b.length;i++){
	  		printBook(b[i].getBook());
	  	}
	  } // writeEntry
  
  private static void printPerson(Person p) {
	    if (p != null) {
	      Out.println("--> " + p.toString());
	    } else {
	      Out.println("--> " + "--");
	    }
	  } // writeEntry
  
  }