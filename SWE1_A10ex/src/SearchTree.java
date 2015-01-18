/* SearchTree.java
 * Software Development 1.13 Binary Tree, Graph and Set
 * Institute for Pervasive Computing, JKU Linz, Austria
 * http://www.pervasive.jku.at
 * author: 2007-10-1 Michael Matscheko
 * last change: 2012-12-11 Michael Matscheko */

// A binary tree that maintains correct order for fast searching.
// All elements have to implement Comparable. The tree is not balanced;
// see Algorithms and Datastructures 2 for more details on data structures.
public class SearchTree {

	BinaryTreeNode root = null; // root node of the tree

	// insert a new value in the tree and return true on success.
	// it is not allowed to insert a value twice or null.
	public boolean insert(Comparable x) {
		if (x == null) return false;
		// try to insert with private insert method
		if (!insert(root, new BinaryTreeNode(x))) {
			// root is null, otherwise insert always returns true
			root = new BinaryTreeNode(x);
		}
		return true;
	}
	
	// private insert method, needed by insert and delete operations
	private boolean insert(BinaryTreeNode node, BinaryTreeNode x) {
		while (node != null) {
			int compare = node.content.compareTo(x.content);
			if (compare == 0)
				return false; // x is already in the tree, return false
			else if (compare > 0) {
				// node value is greater than x
				if (node.left == null) {
					// empty spot to the left, insert here
					node.left = x;
					return true;
				} else {
					// continue in left sub-tree
					node = node.left;
				}
			} else {
				// node value is lower than x
				if (node.right == null) {
					// empty spot to the right, insert here
					node.right = x;
					return true;
				} else {
					// continue in right sub-tree
					node = node.right;
				}
			}
		}
		return false;
	}

	// remove a value from the tree and return true on success.
	public boolean delete(Comparable x) {
		if (x == null) return false;
		// find matching node, start at root
		BinaryTreeNode parent = null, node = root;
		int parentCompare = 0, compare;
		while (node != null) {
			compare = node.content.compareTo(x);
			if (compare == 0) {
				// found matching node, remove it
				BinaryTreeNode replacement;
				if (node.left != null) {
					// there is a left sub-tree, replace this node with left sub-tree
					// first check if there is a right sub-tree we need to move
					if (node.right != null) insert(node.left, node.right);
					replacement = node.left;
				} else {
					// left sub-tree is empty, replace this node with right sub-tree
					replacement = node.right;
				}
				if (parent == null) {
					// special case: replace root node
					root = replacement;
				} else {
					// replace the correct left or right sub-tree of parent node
					if (parentCompare > 0)
						parent.left = replacement;
					else
						parent.right = replacement;
				}
				return true; // x removed, return true
			}
			parent = node;
			parentCompare = compare;
			if (compare > 0) {
				// node value is greater than x
				// continue in left sub-tree
				node = node.left;
			} else {
				// node value is lower than x
				// continue in right sub-tree
				node = node.right;
			}
		}
		// x not found
		return false;
	}

	// find x in tree, return null if not found
	public Comparable lookup(Comparable x) {
		// start with root node
		BinaryTreeNode node = root;
		while (node != null) {
			int compare = node.content.compareTo(x);
			if (compare == 0)
				break;             // matching node found
			else if (compare > 0)  // node value is greater than x
				node = node.left;  // continue in left sub-tree
			else                   // node value is lower than x
				node = node.right; // continue in right sub-tree
		}
		// return node value or null if not found
		return node == null ? null : node.content;
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
		SearchTree t = new SearchTree();
		t.insert("Emil");
		t.insert("Berta");
		t.insert("Dora");
		t.insert("Anton");
		t.insert("Gustav");
		t.insert("Friedrich");

		t.printTree();
		System.out.println("Berta " + (t.lookup("Berta") == null ? "not " : "") + "in list.");
		System.out.println("Otto " + (t.lookup("Otto") == null ? "not " : "") + "in list.");
		
		t.delete("Berta");
		t.printTree();
	}

}
