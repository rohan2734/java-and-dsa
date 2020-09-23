package searching_and_sorting;

public class sumOfTwoArrays {
	public static void sum(int arr1[],int arr2[],int[] output) {
		int i=0,sum=0;
		while(i<arr1.length) {
			sum+=arr1[i]*(Math.pow(10, arr1.length-i-1));
			i++;
		}
		i=0;
		while(i<arr2.length) {
			sum+=arr2[i]*(Math.pow(10, arr2.length-i-1));
			i++;
		}
		int outputLength = Math.max(arr1.length, arr2.length)+1;
		i=0;
		while(i<outputLength-1) {
			output[i]=sum/(int)(Math.pow(10, outputLength-i-1));
			sum=sum%(int)(Math.pow(10, outputLength-i-1));
			i++;
		}
		for(i=0;i<Math.max(arr1.length, arr2.length)+1;i++) {
			System.out.print(output[i] +" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {6,2,4};
		int arr2[]= {7,5,6};
		int outputLength = Math.max(arr1.length, arr2.length)+1;
		int[] output=new int [outputLength];
		sum(arr1,arr2,output);

	}

}
