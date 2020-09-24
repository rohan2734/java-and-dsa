package strings;

public class print_all_prefixes {
	public static void printPrefixes(String str) {
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(str.charAt(j));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcdef";
		printPrefixes(str);
	}

}
