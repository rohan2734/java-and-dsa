package strings;

public class lecturers_revese_word_in_string {
	
	public static void reverseWords(String s) {
		int start=s.length();
		String str="";
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i)==' ') {
				str+= s.substring(i+1,start)+" ";
				start=i;
			}
		}
		str+=s.substring(0,start);
		System.out.print(str.substring(0));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="hi hello how are";
		reverseWords(s);
	}

}
