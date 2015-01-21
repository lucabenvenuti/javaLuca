
public class BinaryTreeExam {
	
	
	public int countIntRange(int min, int max){
		//int a =0;
		
		
	/*	*/
		
	/*	if(min <= node.val && node.val <= max){
			
		}else {
			
		}*/
		
		
		
		return countIntRange(root, min, max);
	}
	
	private int countIntRange(TreeNode node, int min, int max){
		//int a =0;
		
		int count=0;
		
		//tree is not ordered
		if(min <= node.val && node.val <= max){
			count +=1;
		}
		
		if(node.left!=null){
			count+=countIntRange(node.left, min, max);
		}
		if(node.right!=null){
			count+=countIntRange(node.right, min, max);
		}
		
		return count;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
