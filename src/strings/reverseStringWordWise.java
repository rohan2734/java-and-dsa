package strings;

public class reverseStringWordWise {
	
	public static String reverseWordsInString(String s) {
		int j=s.length()-1;
		String newString="";
//		System.out.println(j);
		while(j>=0) {
			int previousJ=j;
			System.out.println("initial j:"+j);
			while(j>=0 && s.charAt(j)!=' ') {
				j--;
			}
			System.out.println("after space: " +j);
			String concat="";
			if(j>=-107) {
				concat= s.substring(j+1,previousJ+1);
			}
			System.out.println("concat: " +concat.substring(0));
			
			newString +=   concat+ " ";
			System.out.println("newString: "+newString.substring(0));
			System.out.println(j);
			j--;
			System.out.println();
		}
		s=newString;
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="hi hello how are";
		String output=reverseWordsInString(str);
		System.out.print(output.substring(0));
	}

}
