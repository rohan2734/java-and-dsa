package strings;

public class count_words {
	
	public static int countWords(String str) {
		int words=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == ' ') {
				words+=1;
			}
		}
		return words+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="this is a sample string";
		int count=countWords(str);
		System.out.print(count);
		
	}

}
