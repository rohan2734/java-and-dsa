package strings;

public class highest_occurance_char {
	public static char highestChar(String str) {
		if(str.length() <=2) {
			return str.charAt(0);
		}
		int[] count=new int[256];
		for(int i=0;i<str.length();i++) {
			count[str.charAt(i)]++;
		}
		int max=Integer.MIN_VALUE;
		int index=0;
		for(int i=0;i<256;i++) {
			if(max<=count[i]) {
				max=count[i];
				index=i;
			}
		}
		char c= (char)index;
		return c;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abdefgbabfba";
		s="ab";
		char c=highestChar(s);
		System.out.print(c);
		
	}

}
