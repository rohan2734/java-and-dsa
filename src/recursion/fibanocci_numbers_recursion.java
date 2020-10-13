package recursion;

public class fibanocci_numbers_recursion {
	
	public static int fibonacci(int n) {
		if(n==0 || n==1) {
			return n;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}

	public static void main(String[] args) {
		int sum=fibonacci(7);
		System.out.print(sum);
	}

}
