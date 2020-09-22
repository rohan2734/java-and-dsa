package searching_and_sorting;

public class selection_sort_by_lecr {
	
	public static void selectionSort(int[] input) {
		for (int i=0;i<input.length-1;i++) {
			
			int min=input[i];
			int minIndex=i;
			for(int j=i+1;j<input.length;j++) {
				if(input[j]<min) {
					min=input[j];
					minIndex=j;
				}
			}
			if(minIndex != i) {
				int temp=input[i];
				input[i]=min;
				input[minIndex]=temp;
			}
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {2,6,9,1,5};
		selectionSort(input);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i] + " ");
		}

	}

}
