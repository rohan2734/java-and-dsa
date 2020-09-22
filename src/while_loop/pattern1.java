package while_loop;

import java.util.Scanner;
import java.lang.Math;

public class pattern1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x=s.nextInt();
		int n=s.nextInt();
		int i=1;
		int result=1;
		while(i<=n) {
			result*=x;
			i+=1;
		}
		System.out.print(result);
		
		
		
	}
}
