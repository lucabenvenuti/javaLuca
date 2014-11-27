import java.util.Arrays;

public class problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int [] source = new int [10];
		int from = 7;
		int to = 25;
		
		int [] source = {4,2, 9, 30, 15, 22, 27};
		
		int i = 0, j = 0;
		
		while(i<source.length){
			if (source[i]>=from && source[i]<=to){
				j=j+1;
			}
			i=i+1;			
		}
		
		int [] destination = new int [j];
		i = 0;
		j = 0;
		
		while (i<source.length){
			if (source[i]>=from && source[i]<=to){
				destination[j]=source[i];
				j=j+1;
			}
			i=i+1;			
		}
			
		System.out.println(Arrays.toString(destination));		
		

	}

}
