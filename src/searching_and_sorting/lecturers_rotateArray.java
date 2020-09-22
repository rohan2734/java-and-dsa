package searching_and_sorting;

public class lecturers_rotateArray {
	
	public static void rotateArray (int[] arr,int d) {
		int i=0;
		int[] arr1= new int[d];
		while(i<d) {
			arr1[i]=arr[i];
			i++;
		}
		i=0;
		while(i<arr.length-d) {
			arr[i]=arr[i+d];
			i++;
		}
		int k=0;
		while(i<arr.length && k<d) {
			arr[i]=arr1[k];
			i++;
			k++;
		}
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i] +" ");
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9};
		rotateArray(arr,2);

	}

}
