package searching_and_sorting;

public class lecturers_second_Largest {
	
	public static int secondLargest(int[] arr) {
		int i=0;
		int s=Integer.MIN_VALUE,l=Integer.MIN_VALUE;
		while(i<arr.length) {
			if(arr[i]>l) {
				s=l;
				l=arr[i];
			}else if(arr[i] <l && arr[i]>s) {
				s=arr[i];
			}
			i++;
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,6,1,9,8,9,7};
//		int arr[]= {6,6};
		System.out.print(secondLargest(arr));

	}

}
