package ifElse;

import java.util.Scanner;

public class odd_or_even {
	
	public static void main(String args[]) {
		Scanner s =new Scanner(System.in);
		
		int n = s.nextInt();
		int rem = n%2;
		if(rem == 0) {
			System.out.println("Even");
		}
	}

}
