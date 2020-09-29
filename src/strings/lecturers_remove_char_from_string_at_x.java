package strings;

public class lecturers_remove_char_from_string_at_x {
	public static String removeAllOccurrencesOfChar(String str, char x) {
	    // Write your code here
       String ans="";
        int i=0;
		while(i<str.length()) 
        {
			if(str.charAt(i) != x) 
            {
				//System.out.println(str.substring(0,i));
				//System.out.println(str.substring(i+1,str.length()));
				//str=str.substring(0,i)+str.substring(i+1,str.length());
				//System.out.println(str);
                ans += str.charAt(i);
			}

			i++;
		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
