package searching_and_sorting;

public class merge_sort {
	
	public static void mergeSort(int[] arr1,int[] arr2) {
		int i=0,j=0,k=0;
		int arr3[] = new int[arr1.length+arr2.length];

		while(k<arr1.length+arr2.length) {

			if(i<arr1.length && j<arr2.length &&  arr1[i]<arr2[j]) {
				arr3[k]=arr1[i];
			
				k++;
				i++;
			}else if(j<arr2.length && i<arr1.length &&  arr1[i]>arr2[j]) {
				arr3[k]=arr2[j];
				
				j++;
				k++;
			}
			if(i==arr1.length) {
				arr3[k]=arr2[j];	
				
				k++;
				j++;
			} 
			if(j==arr2.length) {
				arr3[k]=arr1[i];
				
				k++;
				i++;
			}
		}
		k=0;
		for(k=0;k<arr3.length;k++) {
			System.out.print(arr3[k] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {5,6,7,8};
		int arr2[]={1,2,3,4};
		mergeSort(arr1,arr2);
		

	}

}
