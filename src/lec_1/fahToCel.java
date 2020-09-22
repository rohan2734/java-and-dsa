package lec_1;
import java.util.Scanner;

public class fahToCel {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int f = s.nextInt();
		//int cel=(5/9)*(f-32);
		//float cel = 5*(f-32)/9;
		int cel = (int)((5.0/9)*(f-32));
		System.out.print(cel);

	}

}
