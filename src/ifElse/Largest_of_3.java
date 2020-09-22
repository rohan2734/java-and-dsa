package ifElse;

import java.util.Scanner;

public class Largest_of_3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		char c=str.charAt(0);
		
		if(c >=65 && c<=90) {
			//for capitals
			System.out.println(1);
		}else if(c>=97 && c<=122) {
			System.out.println(0);
		}else {
			System.out.println(-1);
		}
	}

}
