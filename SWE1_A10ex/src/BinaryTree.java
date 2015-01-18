/* BinaryTree.java
 * Software Development 1.13 Binary Tree, Graph and Set
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-12-11 Michael Matscheko */

// A simple binary tree.
public class BinaryTree {

	BinaryTreeNode root = null; // root node of the tree

	// insert a new value in the tree and return true on success.
	// it is not allowed to insert null, but the same value may be added
	// multiple times.
	public boolean insert(Comparable x) {
		if (x == null) return false;
		if (root == null) {
			// special case: tree is empty, create new root node
			root = new BinaryTreeNode(x);
		} else {
			// otherwise insert recursively
			insert(root, new BinaryTreeNode(x));
		}
		return true;
	}

	// private recursive insert method
	private void insert(BinaryTreeNode node, BinaryTreeNode x) {
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

	// remove all values matching x from the tree and return true on success.
	public boolean delete(Comparable x) {
		if (x == null) return false;
		root = delete(root, x);
		return true;
	}

	// private recursive delete method
	private BinaryTreeNode delete(BinaryTreeNode node, Comparable x) {
		// if the node is empty, there is nothing to do
		if (node == null) return null;
		// first remove x from both sub-trees recursively
		node.left = delete(node.left, x);
		node.right = delete(node.right, x);
		// now check if this node needs to be removed
		if (node.content.compareTo(x) == 0) {
			if (node.left != null) {
				// there is a left sub-tree, replace this node with left sub-tree
				// first check if there is a right sub-tree we need to move
				if (node.right != null) insert(node.left, node.right);
				return node.left;
			} else {
				// left sub-tree is empty, replace this node with right sub-tree
				return node.right;
			}
		}
		// not this node, nothing to change
		return node;
	}

	// find first x in tree, return null if not found.
	public Comparable lookup(Comparable x) {
		// start looking in root node
		return lookup(root, x);
	}
	
	// private recursive lookup method
	private Comparable lookup(BinaryTreeNode node, Comparable x) {
		// if the node is empty, we can stop looking here
		if (node == null) return null;
		// if the node matches, return its value
		if (node.content.compareTo(x) == 0) return node.content;
		// otherwise search first in left sub-tree
		Comparable result = lookup(node.left, x);
		// and if there is still no match, check right sub-tree
		if (result == null) result = lookup(node.right, x);
		return result;
	}

	// print the whole tree contents
	public void printTree() {
		if (root == null) {
			System.out.println("empty");
		} else {
			root.printInorder();
			System.out.println();
		}
	}

	// Test binary tree
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.insert("Dora");
		t.insert("Emil");
		t.insert("Anton");
		t.insert("Berta");
		t.insert("Gustav");
		t.insert("Friedrich");

		t.printTree();
		System.out.println("Berta " + (t.lookup("Berta") == null ? "not " : "") + "in list.");
		System.out.println("Otto " + (t.lookup("Otto") == null ? "not " : "") + "in list.");
		
		t.delete("Emil");
		t.printTree();
	}

}
