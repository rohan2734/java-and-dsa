package recursion;

public class remove_X {
	public static String removeX(String input) {
		String output="";
		if(input.length()==1) {
			if(input.charAt(0) == 'x') {
				return "";
			}else {
				return input;
			}
		}
		if(input.length()<=0) {
			return input;
		}
		String small = removeX(input.substring(1));
		if(input.charAt(0) == 'x') {
			return small;
		}else {
			output= input.charAt(0) +small;
			return output;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="xaxb";
		String output=removeX(input);
		System.out.print(output.substring(0));
	}

}
