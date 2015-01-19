import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * PhoneBookNode.java
 *
 * A {@link PhoneBookNode} is used to creates a tree of a phonebook, whereas
 * every node can store a telephone numbers, all node store 1 character of the
 * name and leafs always store a telephone number.
 * 
 * Software Development I, 2014WS 
 * Institute for Pervasive Computing, JKU Linz
 * 
 * @author Michael Haslgrübler
 * @author Andreas Riener
 * @version 2014-12-23
 */
 
public class PhoneBookNode implements Comparable<PhoneBookNode> {
	private char code;
	private String telephoneNumber;
	private SortedSet<PhoneBookNode> children;

	public PhoneBookNode(char code, String telephoneNumber) {
		super();
		this.code = code;
		this.telephoneNumber = telephoneNumber;
		this.children = new TreeSet<PhoneBookNode>();
	}

	public PhoneBookNode(char code) {
		this(code, null);
	}

	public SortedSet<PhoneBookNode> getChildren() {
		return children;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public boolean insert(String name, String telephoneNumber) {
		name = name.toUpperCase();
	//	System.out.println(getChildren().size());
		if(name.length()==0){
		//	System.out.println("supertrota4");
			return false;}
		boolean check = false;
		PhoneBookNode phoneBookNode2 = null;
		char checkChar = name.charAt(0);
		PhoneBookNode phoneBookNode = new PhoneBookNode(checkChar);
		
		if (!getChildren().isEmpty()){
		//	System.out.println("trota3");
			check = false;
			Iterator<PhoneBookNode> it = getChildren().iterator();
			while (it.hasNext()) {	
				phoneBookNode2 = (PhoneBookNode) it.next();
				if (phoneBookNode2.code == checkChar){
				//	System.out.println("trota4");
 					check = true;
 					break;}
			}
		}
		
		if (!check){
		//	System.out.println("trota1");
			getChildren().add(phoneBookNode);
			if(name.length()==1 && phoneBookNode.getTelephoneNumber()==null){
				phoneBookNode.setTelephoneNumber(telephoneNumber);
				return true;
			}
			else if(name.length()==1 && phoneBookNode.getTelephoneNumber()!=null){
				System.out.println("trotaCuloFx");
				return false;
			}
			return phoneBookNode.insert(name.substring(1), telephoneNumber);
			
		}else{
		//	System.out.println("trota2");
			return phoneBookNode2.insert(name.substring(1), telephoneNumber);
		//	this.children = phoneBookNode2.getChildren();
			
			
		}
		
	//	return insert(name.substring(1), telephoneNumber);
		
	//	
	}

	public PhoneBookNode search(String name) {
		// TODO: implement me
		return null;
	}

	@Override
	public String toString() {
		return printPhoneBook(""); // String representation of the entire tree
	}
	/**
	 * This method creates a String representation of the tree starting with the
	 * current node. Each line will consist of: prefix, code and the telephone
	 * number. For every child of this node, this method has to be called
	 * recursively adding the code of this node to the prefix. In total, the
	 * method will return the prefix, code and telephone number of this node
	 * followed by the same of all of its descendants.
	 * 
	 * @param prefix
	 *        a prefix text which should be prepended to every line
	 * @return a string representation of a {@link PhoneBookNode} tree starting
	 *         with this node
	 */
	public String printPhoneBook(String prefix) {
		System.out.print("(");
		
		Iterator<PhoneBookNode> it = getChildren().iterator();
		while (it.hasNext()) {	
			PhoneBookNode phoneBookNode2 = (PhoneBookNode) it.next();
			prefix +=  prefix + Character.toString(phoneBookNode2.code);
			phoneBookNode2.printPhoneBook(prefix);
		}
		/*if (left != null) left.printInorder(); else System.out.print("*");
		System.out.print(" " + content + " ");
		if (right != null) right.printInorder(); else System.out.print("*");
		System.out.print(")");*/
		return null;
	}

	@Override
	public int compareTo(PhoneBookNode o) {
		return Character.compare(this.code, o.getCode());
	}
}
