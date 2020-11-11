package time_and_space_complexity_analysis;

public class rotate_array {
	
	public static void rotateArrayToLeft(int input[],int rotations) {
		int output[] = new int[input.length];
		
		for(int i=0;i< output.length - rotations;i++) {
			output[i] = input[i+rotations];
		}
		
		for(int i=output.length -rotations, k=0;i<output.length && k< rotations;k++,i++) {
			output[i] = input[k];
		}
		
		for(int i=0;i<output.length;i++) {
			input[i] = output[i];
			System.out.print(input[i] +" ");
		}
		
		
	}
	
	public static void reverse(int input[],int si, int ei) {
		while(si<ei) {
			int swap = input[si];
			input[si]=input[ei];
			input[ei]=swap;
			si++;
			ei--;
		}
	}
	
	public static void rotateArray ( int input[], int rotations) {
		reverse(input,0,input.length-1);
		
		reverse(input,0, input.length - 1 - rotations);
		
		reverse(input,input.length - rotations,input.length-1);
		
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+ " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {1,2,3,4,5,6,7};
		int rotations= 2;
//		rotateArrayToLeft(input,rotations);
		rotateArray(input,rotations);
		
	}

}
