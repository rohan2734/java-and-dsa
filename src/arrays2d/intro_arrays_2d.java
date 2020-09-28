package arrays2d;

import java.util.Scanner;

public class intro_arrays_2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr2d[][] = new int[3][4];
		int arr2d_1[][] = {{1,2,3},{4,5,6}};
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of row ");
		int rows = s.nextInt();
		System.out.println("Enter number of cols ");
		int cols=s.nextInt();
		int input[][] = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print("Enter element at "+i+"row " +j+ " col");
				input[i][j]=s.nextInt();
			}
		}
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(input[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
