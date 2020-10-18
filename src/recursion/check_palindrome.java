package recursion;

public class check_palindrome {
	
	public static boolean isPalindrome(String input,int start,int end,boolean result) {
		if(input.length()==1 || start>end) {
			return result;
		}
		if(input.charAt(start) != input.charAt(end)) {
			return false;
		}
		boolean smallAns = isPalindrome(input,start+1,end-1,result);
		return smallAns && result;
	}
	
	public static boolean isPalindrome(String input) {
		boolean result = isPalindrome(input,0,input.length()-1,true);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="racecar";
		boolean result = isPalindrome(input);
		System.out.print(result);
	}

}
