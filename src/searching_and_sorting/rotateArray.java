package searching_and_sorting;

public class rotateArray {
	
	public static void rotateArrays(int[] arr,int d) {
		int i=0;
		while(i<d) {
			int first = arr[0];
			int j=0;
			while(j<arr.length-1) {
				arr[j]=arr[j+1];
				j++;
			}
			arr[arr.length-1]=first;
			i++;
		}
		for( i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,7,8,9};
		int d=2;
		rotateArrays(arr,d);
	}

}
