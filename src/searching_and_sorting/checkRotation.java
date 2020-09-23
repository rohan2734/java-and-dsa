package searching_and_sorting;

public class checkRotation {
	
	public static int checkRotation(int[] arr) {
		if(arr.length ==0) {
			return 0;
		}
		//this i forgot to add
		
		int max=arr[0];
		int index=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
				index=i;
			}
		}
		if(index !=arr.length-1) {
			return index +1;
		}else {
			return 0;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,6,1,2,3,4};
		checkRotation(arr);

	}

}
