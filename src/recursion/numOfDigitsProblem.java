package recursion;

public class numOfDigitsProblem {
	public static int count(int n) {
		if(n/10 == 0) {
			return 1;
		}
		int num=1 + count(n/10);
		return num;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=count(25);
		System.out.print(num);
	}

}
