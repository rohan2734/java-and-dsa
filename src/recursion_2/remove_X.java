package recursion_2;

public class remove_X {
	
	public static String removeX(String str) {
		if(str.length() == 0) {
			return str;
		}
		String ans="";
		if(str.charAt(0) != 'x') {
			ans =ans + str.charAt(0);
		}
		String smallAns = removeX(str.substring(1));
		return ans + smallAns;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="xabdzx";
//		str="xxxx";
		System.out.println(removeX(str));
	}

}
