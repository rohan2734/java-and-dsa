package recursion;

public class pair_Star {
	
	public static String pairStar(String input) {
		String output="";
		if(input.length()==1) {
			return input;
		}
		String smallAns = pairStar(input.substring(0,input.length()-1));
		if(smallAns.charAt(smallAns.length()-1) == input.charAt(input.length()-1)) {
			output =  smallAns.substring(0) + '*' + input.charAt(input.length()-1);
			return output;
		}else {
			output = smallAns.substring(0) + input.charAt(input.length()-1);
			return output;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="hello";
		input="aaaa";
		String output=pairStar(input);
		System.out.println(output.substring(0));
	}

}
