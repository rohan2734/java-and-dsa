package recursion;

public class geometric_sum {
	
	public static double geometricSum(int k,int power,double sum) {
		if(power>k) {
			return sum;
		}
		sum += 1/(Math.pow(2, power));
		return geometricSum(k,power+1,sum);
		
	}
	
	public static double geometricSum(int k) {
		double ans =geometricSum(k,0,0);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=3;
		double ans=geometricSum(k);
		System.out.print(ans);
	}

}
