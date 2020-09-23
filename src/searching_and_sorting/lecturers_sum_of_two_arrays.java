package searching_and_sorting;

public class lecturers_sum_of_two_arrays {
	
	public static void sumOfTwoArrays(int arr1[],int arr2[],int[] output) {
		int i=arr1.length-1,j=arr2.length-1,k=Math.max(arr1.length, arr2.length)+1-1;
		int carry=0;
		int num=0;
		int sum=0;
		while(i>=0 && j>=0) {
			sum=arr1[i] + arr2[j]+carry;
			carry=sum/10;
			num=sum%10;
			output[k]=num;
			i--;
			j--;
			k--;
		}
		while(i>=0 ) {
			sum=arr1[i]+carry;
			carry=sum/10;
			num=sum%10;
			output[k]=num;
			i--;
			k--;
		}
		while(j>=0 ) {
			sum=arr2[j]+carry;
			carry=sum/10;
			num=sum%10;
			output[k]=num;
			j--;
			k--;
		}
		if(k>=0) {
			output[k]=carry;
			k--;
		}
		
		for(i=0;i<output.length;i++) {
			System.out.print(output[i]+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {8,5,2};
		int arr2[]= {1,3};
		int[] output=new int[Math.max(arr1.length, arr2.length) + 1];
		sumOfTwoArrays(arr1,arr2,output);
		
	}

}
