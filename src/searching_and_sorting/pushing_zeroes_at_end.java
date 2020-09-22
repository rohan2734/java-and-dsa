package searching_and_sorting;

public class pushing_zeroes_at_end {
	
	public static void pushZeroes(int[] arr) {
		int i=0,k=0;
		while(i<arr.length) {
			if(arr[i] !=0 ) {
				int swap=arr[k];
				arr[k]=arr[i];
				arr[i]=swap;
				k++;
				i++;
			}else if(arr[i]== 0) {
				i++;
			}
		}
		for(int j=0;j<arr.length;j++) {
			System.out.print(arr[j] + " ");
		}
	
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method s
		int arr[]= {2,0,0,1,3,0,0};
		pushZeroes(arr); 

	}

}
