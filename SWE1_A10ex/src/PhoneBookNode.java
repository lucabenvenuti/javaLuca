import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;


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
 * @author Michael Haslgruebler
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
/*	public boolean insert(char elem) {
		if (elem == '\0'){ return false;
	//	if (root == null) {
			// special case: tree is empty, create new root node
	//		root = new BinaryTreeNode(x);
		} else {
			// otherwise insert recursively
			insert(new PhoneBookNode(elem));
		}
		return true;
	}
	private void insert(PhoneBookNode phoneBookNode) {
	//	Iterator it = getChildren().iterator();
	//	while (it.hasNext()) {
		
//			}
		
		this.children.add(phoneBookNode);
		
	}*/

	public boolean insert(String name, String telephoneNumber) {

		for (char elem : name.toCharArray()) {
			System.out.println(elem);
			
			Iterator it = getChildren().iterator();
			PhoneBookNode phoneBookNode = null;
			boolean isANewNode = true;
			while (it.hasNext()) {
				phoneBookNode = (PhoneBookNode) it.next();
				System.out.println(phoneBookNode.code);
				int compare = compareTo(phoneBookNode); 
				if (compare == 0){
					isANewNode = false;
					break;
				}
				}
			if (isANewNode){
				getChildren().add(new PhoneBookNode(elem));
			}
		//	System.out.println(this.code+2);
			if (this.code == '\0'){getChildren().add(new PhoneBookNode(elem));
			it = getChildren().iterator();}
			else{it = phoneBookNode.getChildren().iterator();}
		//	
			while (it.hasNext()) {
				phoneBookNode = (PhoneBookNode) it.next();
				System.out.println(phoneBookNode.code);
				int compare = compareTo(phoneBookNode); 
				if (compare == 0){
					isANewNode = false;
					break;
				}
				}
			if (isANewNode){
				getChildren().add(new PhoneBookNode(elem));
			}
			
			
		}
		//	System.out.println(insert(elem));
		//	getChildren().first().insert(elem);
			
		/*	PhoneBookNode phoneBookNode = new PhoneBookNode(elem);
			
			
			if (compare == 0)
				//return false; // x is already in the tree, return false
		//	else if (compare > 0) {
				// node value is greater than x
			//	if (node.left == null) {
					// empty spot to the left, insert here
		//			node.left = x;
		//			return true;
		//		} else {
					// continue in left sub-tree
		//			node = node.left;
		//		}*/
				
		//	this.code = elem;
		//	this.children.add(new PhoneBookNode(elem));
			
		
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
		}
		Iterator it = getChildren().iterator();
			while (it.hasNext()) {
			
				}
		
		Iterator it = set.iterator();
28
        while (it.hasNext()) {
29
            // Get employee name and age
30
            Employee epm = (Employee) it.next();
31
            System.out.println("Employee " + epm.getName() + ", his age: " + epm.getAge());
32
        }

			int compare = node.content.compareTo(x);
			if (compare == 0)
				break;             // matching node found
			else if (compare > 0)  // node value is greater than x
				node = node.left;  // continue in left sub-tree
			else                   // node value is lower than x
				node = node.right; // continue in right sub-tree
		*
		*
		*/

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
