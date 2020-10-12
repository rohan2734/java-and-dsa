package recursion;

public class calculatePower {
	
	public static int power(int n, int p) {
		if(p==1) {
			return n;
		}
		return n*power(n,p-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=power(5,2);
		System.out.print(n);
	}

}
