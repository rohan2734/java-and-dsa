package arrays_1;

import java.util.Scanner;

public class printArraySum {
	public static void arrange(int[] arr, int n) {
	    int oddNum=1;
	    int evenNum= (n%2 == 0) ? n : n-1;
	    for(int i=0;i<(n/2);i++){
	        arr[i] = oddNum;
	        oddNum+=2;
	    }
	    for(int i=(n/2);i<n;i++){
	        arr[i]=evenNum;
	        evenNum-=2;
	    }
	    for(int i=0;i<n;i++){
	        System.out.print(arr[i]+" ");
	    }
	    
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner s =new Scanner(System.in);
//		int size = s.nextInt();
//		int arr[] = new int[size];
//		arrange(arr,size);
		
		
		
		

	}

}
