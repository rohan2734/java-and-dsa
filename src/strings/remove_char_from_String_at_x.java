package strings;

public class remove_char_from_String_at_x {
	public static String removeChars(String str,char x) {
		int i=0;
		while(i<str.length()) {
			if(str.charAt(i) == x) {
				//System.out.println(str.substring(0,i));
				//System.out.println(str.substring(i+1,str.length()));
				str=str.substring(0,i)+str.substring(i+1,str.length());
				//System.out.println(str);
			}
			i++;
		}
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="welcome to coding ninjas";
		s="codddnnnnn";
		s=removeChars(s,'n');
		System.out.print(s.substring(0));

	}

}
