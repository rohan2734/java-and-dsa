package strings;

public class reverse_chars_in_words {
	public static String reverseLetters(String str) {
		int i=str.length()-1;
		String s="";
		while(i>=0) {
			s+=str.charAt(i);
			i--;
		}
		return s;
	}
	
	public static String reverseWords(String str) {
		String s="";
		int i=str.length()-1;
		int previousI=i;
		while(i>=0) {
			if(str.charAt(i)!=' ') {
				i--;
			}else {
				System.out.println("entered ' ' i:"+ i +"previousI :"+previousI);
				String sub=str.substring(i+1,previousI+1);
				System.out.println("before reverse: "+sub.substring(0));
				sub=reverseLetters(sub);
				System.out.println("after reverse: "+sub.substring(0));
				s=sub+" "+s;
				System.out.println("after concat: "+s);
				i--;
				previousI=i;
			}
			
		}
		String sub=str.substring(i+1,previousI+1);
		sub=reverseLetters(sub);
		s=sub+" " + s;
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcd ef ghi";
		String str=reverseWords(s);
		System.out.print(str.substring(0));
	}

}
