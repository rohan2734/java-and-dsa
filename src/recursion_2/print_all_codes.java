package recursion_2;

public class print_all_codes {
	
	public static char getChar(int num) {
		return (char)(96 + num);
	}
	
	public static void printAllCodes(String input,String outputSoFar) {
		if(input.length() == 0) {
			System.out.println(outputSoFar.substring(0));
			return;
		}
		int firstDigit = (int)(input.charAt(0) - '0');
		//smallOutput1
		char firstChar = getChar(firstDigit);
		printAllCodes(input.substring(1),outputSoFar+firstChar);
		
		//smallOutput2
		int firstTwoDigits = 0;
		if(input.length()>=2) {
			firstTwoDigits = (int)((input.charAt(0)-'0')*10 + input.charAt(1)-'0');
			
			char firstTwoChar = getChar(firstTwoDigits);
			if(firstTwoDigits>=10 && firstTwoDigits<=26) {
				printAllCodes(input.substring(2),outputSoFar + firstTwoChar);
			}
		}
	}
	
	public static void printAllCodes(String input) {
		printAllCodes(input,"");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="1123";
		printAllCodes(input);
	}

}
