/**
 * PhoneBook.java
 *
 * A {@link PhoneBook} is used to create a phonebook, it contains user interaction and allows the
 * user to add names and numbers to the actual PhoneBook
 *
 * Software Development I, 2014WS Institute for Pervasive Computing, JKU Linz
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

        root.insert("Andy", "342");
        root.insert("Ann", "232");
        root.insert("Anna", "123");
        root.insert("Anni", "564");
        root.insert("Matt", "253");
        root.insert("Mike", "346");
        root.insert("Molly", "744");
        root.insert("Toni", "734");

        PhoneBookNode node = root.search("Ann");
        if (node == null) {
            System.out.println("Your phonebook is empty, or the entry is not found");
        } else {
            System.out.println("The following contacts have been found:");
            System.out.println(node.printPhoneBook("AN"));
        }
        System.out.println("--------------------------");
        printPhoneBook();
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.run();
    }
}