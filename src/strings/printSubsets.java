package strings;

public class printSubsets {
	public static void subsets(String str) {
		boolean entered=true;
		for(int i=0;i<str.length();i++) {
			for(int len=1;len<=str.length();len++) {
				for(int j=i;j<len;j++) {
					entered=true;
					System.out.print(str.charAt(j));
				}
				if(entered==true) {
					System.out.println();
				}
				entered=false;
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcdef";
		subsets(str);
	}

}
