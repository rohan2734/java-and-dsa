package arrays_1;

import java.util.Scanner;

public class MaxNumber {
	
	public static int findLargest(int input[]) {
		int size=input.length;
		int max= Integer.MIN_VALUE;
		for(int i=0;i<size;i++) {
			if(max<=input[i]) {
				max=input[i];
			}
		}
		return max;
	}
	
	public static void print(int input[]) {
		int size= input.length;
		for(int i=0;i< size;i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
		
	}
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size=s.nextInt();
		int input[]=new int[size];
		for(int i=0;i<size;i++) {
			input[i] = s.nextInt();
		}
		return input;
	}

	public static void main(String[] args) {
		
		int arr[] = takeInput();
		int max=findLargest(arr);
		print(arr);
		System.out.print(max);

	}

}
