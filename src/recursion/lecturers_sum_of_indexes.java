package recursion;

public class lecturers_sum_of_indexes {
	
	public static  int[] sumOfIndexes(int input[],int x,int startIndex) {
		if(startIndex==input.length) {
			int arr[] = new int[0];
			return arr;
		}
		int smallOutput[] = sumOfIndexes(input,x,startIndex + 1);
		int output[] = new int [smallOutput.length+1];
		if(input[startIndex] == x) {
			
			output[0]=startIndex;
			for(int i=0;i<smallOutput.length;i++) {
				output[i+1]=smallOutput[i];
			}
			return output;
		}
		
		return smallOutput;

	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {9,8,10,8,8};
		int x=8;
		int arr[]=sumOfIndexes(input,x,0);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
