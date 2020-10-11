package functions;

import java.util.Scanner;

public class primeNumbers {
	public static boolean checkPrime(int n) {
		int d=2;
		while(d<n) {
			if( n%d == 0) {
				return false;
			}
			d++;
		}
		return true;
	}
	
	public static void printPrimes(int n) {
		for(int i=2;i<=n;i++) {
			boolean isPrime = checkPrime(i);
			if(isPrime) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		int n = s.nextInt();
		printPrimes(n);
		
	}

}
