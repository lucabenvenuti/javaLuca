//package at.jku.pervasive.swe14.UE12.binaryTree;

class Tree {
	TreeNode root;

	Tree() {
		root = null; 
	}

	// public method
	public int countInRange(int min, int max)
	{
		return countInRange2(root, min, max);
	}
	// private, recursive method (criteria of binary search tree)
	private int countInRange2(TreeNode node, int min, int max)
	{
		if (node == null) {     // termination condition
			return 0;
		}

		int count = 0;          
		// processing
	
		if ((min <= node.val) && (node.val <= max)) {
			count ++; // actual element in range
		}

		// two recursive calls
		if (min < node.val) {  // without 'if': also correct, but less performant  
			count += countInRange2(node.left, min, max);
		}

		if (node.val <= max) { // without 'if': also correct, but less performant
			count += countInRange2(node.right, min, max);
		}

		return count;
	}
}