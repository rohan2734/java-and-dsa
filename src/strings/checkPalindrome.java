package strings;

public class checkPalindrome {
	
	public static boolean isPalindrome(String str) {
		boolean isValid=true;
		int i=0,j=str.length()-1;
		while(i<=j) {
			if(str.charAt(i)==str.charAt(j)) {
				i++;
				j--;
				isValid= isValid&&true;
			}else {
				return false;
			}
		}
		
		return isValid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "abcdcba";
		boolean isValid=isPalindrome(str);
		System.out.print(isValid);

	}

}
