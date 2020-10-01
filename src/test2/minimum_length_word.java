package test2;

public class minimum_length_word {
	public static String minimumLengthWord(String sen) {
		int i=0;
		int previousI=0;
		int minLen=Integer.MAX_VALUE;
		String minString="";
		while(i<sen.length()) {
			
			if(sen.charAt(i)!=' ') {
				i++;
			}else {
				int len=i-previousI;
				if(len<minLen) {
					minLen=len;
					minString=sen.substring(previousI,i);
				}
				 
				i++;
				previousI=i;
			}
			
			
		}
		return minString;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sen="this is test";
		sen=minimumLengthWord(sen);
		System.out.print(sen.substring(0));
	}

}
