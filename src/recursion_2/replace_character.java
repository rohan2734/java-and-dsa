package recursion_2;

public class replace_character {
	
	public static String replaceCharacter(String input,char c1,char c2) {
		if(input.length() == 0) {
			return input;
		}
		String ans="";
		if(input.charAt(0) == c1) {
			ans+=c2;
		}else {
			ans+=input.charAt(0);
		}
		String smallAns = replaceCharacter(input.substring(1),c1,c2);
		return ans + smallAns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input= "abacd";
		char c1='a';
		char c2='x';
		System.out.print(replaceCharacter(input,c1,c2));
	}

}
