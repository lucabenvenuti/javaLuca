
public class TubeAssembling {
	
	boolean possible(int length, int l1, int l2, int l3){
		if(length==0){
			return true;
		}	else {
			boolean solution = false;
			solution = solution || possible(length-l1,l1,l2,l3);
			solution = solution || possible(length-l2,l1,l2,l3);
			solution = solution || possible(length-l3,l1,l2,l3);
			return solution;
		}	
		
	//	return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TubeAssembling newTubeAssembling = new TubeAssembling();
		System.out.println(newTubeAssembling.possible(120,5,8,7));
	}

}
