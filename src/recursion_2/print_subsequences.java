package recursion_2;

public class print_subsequences {
	
	public static void printSubsequences(String input,String outputSoFar) {
		if(input.length() == 0) {
			System.out.println(outputSoFar);
			return;
		}
		//exclude first char
		printSubsequences(input.substring(1),outputSoFar);
		//include first char
		printSubsequences(input.substring(1),outputSoFar+input.charAt(0));
		
	}
	
	public static void printSubsequences(String input) {
		printSubsequences(input,"");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="xyz";
		printSubsequences(input);
	}

}
