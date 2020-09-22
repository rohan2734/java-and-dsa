package searching_and_sorting;

public class selection_sort {
	
	public static void selectionSort(int[] input) {
		int pos=0;
		for(int i=0;i<input.length-1;i++) {
			//find min;
			int min=input[i];
			pos=i;
			for(int j=i+1;j<input.length;j++) {
				
				if(min>input[j]) {
					min=input[j];
					pos=j;
				}
			}
			int swap=input[i];
			input[i]=input[pos];
			input[pos]=swap;			
			

			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {7,2,9,6,1,5,4};
		selectionSort(input);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}

	}

}
