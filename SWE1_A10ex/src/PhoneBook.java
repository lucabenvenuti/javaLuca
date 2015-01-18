/**
 * PhoneBook.java
 *
 * A {@link PhoneBook} is used to create a phonebook, it contains user
 * interaction and allows the user to add names and numbers to the actual
 * PhoneBook
 * 
 * Software Development I, 2014WS 
 * Institute for Pervasive Computing, JKU Linz
 * 
 * @author Michael Haslgrübler
 * @author Andreas Riener
 * @version 2014-12-23
 */

public class PhoneBook {

	private PhoneBookNode root;

	public PhoneBook() {
		root = new PhoneBookNode('\0', null);
	}

	private void printPhoneBook() {
		System.out.println(root.printPhoneBook(""));
	}

	public void run() {
		boolean quit = false;
		System.out.println("Welcome to your phonebook");
		while (quit == false) {
			System.out.println("What do you want to do?");
			System.out.println("Inserting a new contact:   press i");
			System.out.println("Search for a number:       press s");
			System.out.println("Print all the entries:     press p");
			System.out.println("Quit the application:      press q");

			System.out.println();
			char control = Input.readChar();
			switch (control) {
			case 'i': {
				System.out.println("Please enter the name of your new contact");
				String name = Input.readString();
				System.out.println("Please enter the telephone number");
				String number = Input.readString();
				root.insert(name, number);
				System.out.println();
				break;
			}
			case 's': {
				System.out.println("Please enter name of the contact");
				String name = Input.readString();
				PhoneBookNode node = root.search(name);
				if (node == null) {
					System.out.println("Your phonebook is empty, or the entry is not found");
				} else {
					System.out.println("The following contacts have been found:");
					//TODO: implement me
				}
				System.out.println();
				break;
			}
			case 'p': {
				printPhoneBook();
				System.out.println();
				break;
			}
			case 'q':
				quit = true;
				break;
			}
		}
	}

	public static void main(String[] args) {
		PhoneBook pb = new PhoneBook();
		pb.run();
	}
}