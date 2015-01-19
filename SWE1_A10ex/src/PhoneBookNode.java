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
	
	public int insert(char[] nameCharArray, SortedSet<PhoneBookNode> treeSet, int i) {
		System.out.println(treeSet.stream());
		if (i<nameCharArray.length){
			char elem2 = nameCharArray[i];
		
			PhoneBookNode phoneBookNode = new PhoneBookNode(elem2);
		
		boolean check = true;
		if (!treeSet.isEmpty()){
	
			check = false;
			Iterator<PhoneBookNode> it = treeSet.iterator();
				
			while (it.hasNext()) {
			
				PhoneBookNode phoneBookNode2 = it.next();
				int compare = compareTo(phoneBookNode2);
			
				if (compare != 0){
					check = true;
					}
				}
		}
		if (check){
			this.code = phoneBookNode.code;
			treeSet.add(phoneBookNode);
			System.out.println("insert code ok");
			this.children = phoneBookNode.getChildren();
			if (i==nameCharArray.length-1){
				phoneBookNode.telephoneNumber = telephoneNumber;}
			return insert(nameCharArray, this.children, i+1);
		}
		else {
			return insert(nameCharArray, treeSet, i);
		}
		
		}
		return 1000;
	}

	public boolean insert(String name, String telephoneNumber) {
	
		SortedSet<PhoneBookNode> treeSet = this.children;
		char[] nameCharArray = name.toCharArray();
		int a = insert(nameCharArray, treeSet, 0);
		
	/*	for (char elem : name.toCharArray()) {
			System.out.println(elem);
			phoneBookNode = insert(new PhoneBookNode(elem), treeSet);
			treeSet = phoneBookNode.getChildren();
			elem2 = elem;
		}*/
		
		return false;
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
		// TODO: implement me
		return null;
	}

	@Override
	public int compareTo(PhoneBookNode o) {
		return Character.compare(this.code, o.getCode());
	}
}
