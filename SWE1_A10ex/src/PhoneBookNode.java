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
	//	System.out.println(treeSet);
		if (i<nameCharArray.length){
			char elem2 = nameCharArray[i];
		//	System.out.println(elem2);
			PhoneBookNode phoneBookNode = new PhoneBookNode(elem2);
		//	System.out.println(phoneBookNode.code);
		boolean check = true;
		if (!treeSet.isEmpty()){
		//	System.out.println("trota3");
			check = false;
			Iterator it = treeSet.iterator();
		//	System.out.println(it);
		//	System.out.println(treeSet.size());
			
			while (it.hasNext()) {
			//	System.out.println("trota3");
				PhoneBookNode phoneBookNode2 = (PhoneBookNode) it.next();
			//	System.out.println(phoneBookNode2);
				//this.code = phoneBookNode2.code;
			//	System.out.println(phoneBookNode.code);
				String s = "" + this.code + phoneBookNode.code;
		//		System.out.println(s);
				s = "";
				int compare = compareTo(phoneBookNode);
			//	System.out.println(compare);
				if (compare != 0){
					check = true;
				//	System.out.println("trota2");
					}
				}
			//this.code = treeSet.first().code;
		}
		//else{System.out.println("trota6");}
		if (check){
			this.code = phoneBookNode.code;
		//	System.out.println(this.code);
			treeSet.add(phoneBookNode);
		//	System.out.println("trota");
			this.children = phoneBookNode.getChildren();
			//System.out.println(this.children);
			//return  i-1;
			if (i==nameCharArray.length-1){
				phoneBookNode.telephoneNumber = telephoneNumber;}
		//	System.out.println("trota1");
			return insert(nameCharArray, this.children, i+1);
		}
		else {//return  i;
	//	System.out.println("trota2");
			return insert(nameCharArray, treeSet, i);
		}
		
		
		}
	//	System.out.println("trota3");
		return 1000;
	}

	public boolean insert(String name, String telephoneNumber) {
	//	System.out.println(this.code);
		
	//	System.out.println(this);
		SortedSet<PhoneBookNode> treeSet = this.children;
		System.out.println(treeSet);
	//	char elem2 = '?';
	//	PhoneBookNode phoneBookNode = null;
		char[] nameCharArray = name.toCharArray();
		int a = insert(nameCharArray, treeSet, 0);
		
	/*	for (char elem : name.toCharArray()) {
			System.out.println(elem);
			phoneBookNode = insert(new PhoneBookNode(elem), treeSet);
			treeSet = phoneBookNode.getChildren();
			elem2 = elem;
		}*/
		
	//	insertNumber(this.children, telephoneNumber, elem2);
		
		return false;
	}

	/*public void insertNumber(SortedSet<PhoneBookNode> treeSet, String telephoneNumber, char elem2)	{
	//	SortedSet<PhoneBookNode> treeSet = this.children;
		Iterator it = treeSet.iterator();
		while (it.hasNext()) {
			
				System.out.println("trota3");
				PhoneBookNode phoneBookNode2 = (PhoneBookNode) it.next();
				this.code = phoneBookNode2.code;
				int compare = compareTo(new PhoneBookNode(elem2));
			//	System.out.println(compare);
				if (compare == 0){
					if (!treeSet.isEmpty()){}
					setTelephoneNumber(telephoneNumber);
					System.out.println("trota6");
					}
				}
	}
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
