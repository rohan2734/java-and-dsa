package strings;

public class remove_consectuive_strings {
	public static String removeConsecutiveString(String s) {
		int i=0,j=0;
		String str="";
		while(i<s.length() && j<s.length()) {
			if(i==j) {
				str+=s.charAt(i);
				j++;
			}else if(s.charAt(i)==s.charAt(j)) {
				j++;
			}else {
				i=j;
				str+=s.charAt(i);
				j++;
			}
		}
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aabccbaa";
		System.out.print(removeConsecutiveString(str));

	}

}
