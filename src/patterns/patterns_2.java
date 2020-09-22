package patterns;

import java.util.Scanner;
import java.lang.Math;


public class patterns_2 {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		long n =s.nextLong();
		long r;
		long dN =n,digits=0;
		while(dN>0) {
			r=dN%10;
			dN/=10;
			digits+=1;
		}
		
		dN=n;
		long sum=0;
		while(dN>0) {
			r=dN%10;
			sum+=  Math.pow(r, digits);
			dN/=10;
		}
		if(sum == n) {
			System.out.print("true");
		}else {
			System.out.print("false");
		}
	
	}
}
