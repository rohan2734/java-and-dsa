package recursion;

public class factorial {
	
	public static int fact(int n) {
		
		int smallAns=fact(n-1);
		return n*smallAns;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		int ans=fact(n);
		System.out.println(ans)
		
	}

}
