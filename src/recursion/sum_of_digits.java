package recursion;

public class sum_of_digits {
	
	public static int digitsSum(int ans) {
		if(ans/10 == 0) {
			return ans;
		}
		int sum=ans%10;
		return sum+digitsSum(ans/10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=12345;
		int ans=digitsSum(num);
		System.out.print(ans);
	}

}
