/* BinaryTreeNode.java
 * Software Development 1.13 Binary Tree, Graph and Set
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-12-11 Michael Matscheko */

// A node in a binary tree.
public class BinaryTreeNode {
	
	Comparable content;     // node content / value
	BinaryTreeNode left, right; // left and right sub-trees

	// create leaf node
	public BinaryTreeNode(Comparable content) {
		this.content = content;
		this.left = null;
		this.right = null;
	}

	// create inner node
	public BinaryTreeNode(BinaryTreeNode left, Comparable content, BinaryTreeNode right) {
		this.content = content;
		this.left = left;
		this.right = right;
	}

	// convert this node to its String representation
	public String toString() {
		return content.toString();
	}
	
	// print the whole sub-tree
	public void printInorder() {
		System.out.print("(");
		if (left != null) left.printInorder(); else System.out.print("*");
		System.out.print(" " + content + " ");
		if (right != null) right.printInorder(); else System.out.print("*");
		System.out.print(")");
	}
	
}
