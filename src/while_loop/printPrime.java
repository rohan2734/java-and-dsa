package while_loop;

import java.util.Scanner;

public class printPrime {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sf =s.nextInt();
		int e =s.nextInt();
		int w =s.nextInt();
		int c;
		while(sf<=e) {
			c=(5*(sf-32))/9;
			System.out.print(sf);
			System.out.print("\t");
			System.out.print(c);
			System.out.print("\n");
			sf+=w;
		}
	}

}
