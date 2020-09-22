package searching_and_sorting;

public class secondLargestNumber {
	
	public static int secondLargest(int[] arr) {
		int i=0,j=1;
		int max=0;
		while(j<arr.length) {
			if(arr[i]<arr[j]) {
				max=arr[j];
				i=j;
				
			}else {
				j++;
			}
		}
		i=0;
		while(i<arr.length) {
			if(arr[i] == max) {
				arr[i] =0;
			}
			i++;
		}
		i=0;j=1;
		max=0;
		while(j<arr.length) {
			if(arr[i]<arr[j]) {
				max=arr[j];
				i=j;
				
			}else {
				j++;
			}
		}
//		return max;
		if(max != 0) {
			return max;
		}else {
			return -2147483648;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {2,12,4,1,3,6,28};
		int arr[] = {6,6};
		System.out.print(secondLargest(arr));
	}

}
