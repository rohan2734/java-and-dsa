package recursion_2;

public class remove_duplicates {
	public static String removeDuplicates(String input) {
		if(input.length() ==  0 || input.length() == 1) {
			return input;
		}
		String ans="";
		if(input.charAt(0) != input.charAt(1)) {
			ans = ans +input.charAt(0);
		}
		String smallAns =removeDuplicates(input.substring(1));
		return ans + smallAns;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="aabccba";
		System.out.print(removeDuplicates(input));
	}

}
