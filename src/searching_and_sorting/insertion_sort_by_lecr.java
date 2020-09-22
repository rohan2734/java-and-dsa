package searching_and_sorting;

public class insertion_sort_by_lecr {
	
	public static void insertionSort(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			int j=i-1;
			int temp=arr[i];
			while(j>=0 && arr[j]>temp ) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {6,4,5,3,2};
		insertionSort(input);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i] + " ");
		}

	}

}
