package recursion;

public class convert_String_to_numbers {
	
	public static int convertStringToNumber(String input,int startIndex) {
		int num=0;
		if(startIndex >=input.length()) {
			return num;
		}
		char numChar=input.charAt(startIndex);
		num = Integer.parseInt(String.valueOf(numChar));
		num = num*(int)(Math.pow(10, input.length() - startIndex -1));
		int smallAns = num + convertStringToNumber(input,startIndex+1);
		return smallAns;
	}
	
	public static int convertStringToNumber(String input) {
		int num;
		if(input.length()==1) {
			char numChar = input.charAt(0);
			num=Integer.parseInt(String.valueOf(numChar));
			return num;
		}
		int smallAns = convertStringToNumber(input.substring(1));
		char numChar = input.charAt(0);
		num=Integer.parseInt(String.valueOf(numChar));
		num = num*(int)(Math.pow(10,input.length() -1)) +smallAns;
		return num;
	}
	
	public static int convertString(String input) {
		if(input.length() ==1) {
			return input.charAt(0) - '0';
		}
		int smallOutput= convertString(input.substring(0, input.length()-1));
		int lastDigit = input.charAt(input.length()-1) - '0';
		return smallOutput*10 + lastDigit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="1231";
		int output1=convertStringToNumber(input);
		System.out.print(output1);
		int output=convertStringToNumber(input,0);
		System.out.print(output);
	}

}
