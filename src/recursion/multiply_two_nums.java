package recursion;

public class multiply_two_nums {
	public static int multiplyTwoNum(int m,int n) {
		if(n==0) {
			return 0;
		}

		int sum=0;
		sum= m + multiplyTwoNum( m,n-1);
		return sum;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=4,n=0;
		int ans=multiplyTwoNum(m,n);
		System.out.print(ans);
	}

}
