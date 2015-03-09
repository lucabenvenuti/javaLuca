package library.app;

import library.BookNode;
import library.Library;
import library.Book;
import library.Person;
import library.PersonNode;
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
	  
	  String s01 = "  a - insert book ";
	  String s02 = "  b - insert user ";
	  String s03 = "  c - check book availability ";
	  String s04 = "  d - given a keyword, show all books with it in the title ";
      String s05 = "  e - show all lendings of one person ";		
      String s06 = "  f - lend a book ";
      String s07 = "  g - give a book back ";
      String s08 = "  h - show all books by ID number ";
      String s09 = "  i - show all users by ID number ";
      String s10 = "  l - show all overdued books ";
      String s11 = "  n - ask if a book is lended ";
/*   	  String s02 =
      String s02 =			
      String s02 =
      String s02 =	
      String s02 =
      String s02 =	*/
	    // Put out operations
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
	      case 'a': // insert new entry
	    	Out.println(s01);
	        Out.print("   Please write the title into apexes (\"\"): ");
	        String name = In.readString();
	      //  Out.print(name);
	        Out.print("   Please write the location into apexes (\"\"): ");
	        String location = In.readString();
	        Out.println("   Successfully inserted book: ");
	        printBookNode(lucaLibrary.insertBook(name, location));
	        break;
	      case 'b': // insert new entry
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
	      case 'c': // insert new entry
	    	    Out.println(s03);
		        Out.print("   Please write the title into apexes (\"\") the title to check existance: ");
		        name = In.readString();
		        printBookAvailability(name, lucaLibrary.containsBook(name));
		        break;    
	      case 'd': // insert new entry
	    	    Out.println(s04);
		        Out.print("   Please write the title into apexes (\"\") to show all compatible books: ");
		        name = In.readString();
		        Out.println("   The compatible books with the keyword \"" + name + "\" are: ");
		        printBookArray(lucaLibrary.getBookNodeTitleArray(name));
		        break;    
	      case 'e': // insert new entry
	    	    Out.println(s05);
		        Out.print("   Please write the person's ID to show all his/her lending: ");
		        int id = In.readInt();
		        Out.println("   The books borrowed by user \"" + id + "\" are: ");
		        printBookArray(lucaLibrary.getBookNodePersonArray(id));
		        break;        
	      case 'f': // insert new entry
	    	    Out.println(s06);
		        Out.print("   Please write the person's ID to lend: ");
		        int idPerson = In.readInt();
		        Out.print("   Please write the book's ID to lend: ");
		        int idBook = In.readInt();
		        Out.print(lucaLibrary.lendBook(idPerson, idBook));
		        break;     
	      case 'g': // insert new entry
	    	    Out.println(s07);
		        Out.print("   Please write a book's ID to give it back: ");
		        idBook = In.readInt();
		        Out.print(lucaLibrary.givebackBook(idBook));
		        break;   
	      case 'h': // insert new entry
	    	    Out.println(s08);
		        Out.print("   show all books by ID number: ");
		        printBookArray(lucaLibrary.getBookArray());
		        break;  
	      case 'i': // insert new entry
	    	    Out.println(s09);
		        Out.print("   show all users by ID number: ");
		        printPersonArray(lucaLibrary.getPersonArray());
		        break;  
	      case 'l': // insert new entry
	    	    Out.println(s10);
		        Out.print("   List of all overdued books: ");
		        printBookArray(lucaLibrary.overdue());
		        break;  
	      case 'n': // insert new entry
	    	    Out.println(s11);
		        Out.print("   Please write the book's ID to check availability: ");
		        idBook = In.readInt();
		        Out.print(lucaLibrary.available(idBook));
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
  
  private static void printBookNode(BookNode insertBook) {
	  printBook(insertBook.getBook());	
	}

  
  private static void printBookArray(BookNode[] b) {
	  Out.println("");
	  	for(int i=0; i<b.length;i++){
	  		//System.out.println(i);
	  		printBook(b[i].getBook());
	  		
	  	}Out.println("");
	  } // writeEntry
  
  private static void printPersonArray(PersonNode[] p) {
	  Out.println("");
	  	for(int i=0; i<p.length;i++){
	  		printPerson(p[i].getPerson());
	  	}
	  	Out.println("");
	  } // writeEntry
  
  private static void printPerson(Person p) {
	    if (p != null) {
	      Out.println("--> " + p.toString());
	    } else {
	      Out.println("--> " + "--");
	    }
	  } // writeEntry
  
  private static void printPersonNode(PersonNode insertPerson) {
	  printPerson(insertPerson.getPerson());	
  }
  
  private static void printBookAvailability(String name, boolean containsBook) {
	  if (containsBook){
		  Out.println("The book \"" + name + "\" is available.");
	  } else {
		  Out.println("The book \"" + name + "\" is not available.");
	  }
	}
  
  }