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

		for (char elem : name.toCharArray()) {
			System.out.println(elem);
			
			}
		
		return false;
	}
	
	// private recursive insert method
/*		private void insert(BinaryTreeNode node, BinaryTreeNode x) {
			if (node.left == null) {
				// empty spot to the left, insert here
				node.left = x;
			} else if (node.right == null) {
				// empty spot to the right, insert here
				node.right = x;
			} else {
				// continue in left sub-tree
				insert(node.left, x);
			}
		}*/

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
		// TODO: implement me
		return null;
	}

	@Override
	public int compareTo(PhoneBookNode o) {
		return Character.compare(this.code, o.getCode());
	}
}
