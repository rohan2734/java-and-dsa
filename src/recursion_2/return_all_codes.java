package recursion_2;

public class return_all_codes {
	
	public static char getChar(int num) {
		return (char)(96 + num);
	}
	
	public static String[] getCode(String input) {
		if(input.length() == 0) {
			String ans[]= {""};
			return ans;
		}
		int firstDigit = (int)(input.charAt(0)-'0');
		String smallOutput1[]=getCode(input.substring(1));
		String smallOutput2[] = new String[0];
		int firstTwoDigits=0;
		if(input.length()>=2) {
			firstTwoDigits = (int)((input.charAt(0) - '0')*10 + (input.charAt(1)-'0')); 
			if(firstTwoDigits >= 10 && firstTwoDigits <=26 ) {
				smallOutput2 = getCode(input.substring(2));
			}
		}
		
		String output[] = new String[smallOutput1.length + smallOutput2.length];
		int k=0;
		for(int i=0;i<smallOutput1.length;i++) {
			String s=smallOutput1[i];
			char firstDigitChar = getChar(firstDigit);
			output[k] = firstDigitChar + s;
			k++;
		}
		
		for(int i=0;i<smallOutput2.length;i++) {
			String s=smallOutput2[i];
			char firstTwoDigitChar = getChar(firstTwoDigits);
			output[k] = firstTwoDigitChar + s;
			k++;
		}
		
		return output;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="1123";
		String output[]=getCode(input);
		for(int i=0;i<output.length;i++) {
			System.out.println(output[i].substring(0));
		}
	}

}
