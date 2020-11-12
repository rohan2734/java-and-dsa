package test_3_time_complexity_and_recursion;

public class check_sequence {
	
//	public static boolean checkSequence(String a,String b) {
//		int b_si=0;
//		int a_si=0;
//		
//		if(a.length() == 0 )
//		while(a_si < a.length()) {
//			if(a.charAt(a_si) == b.charAt(b_si)) {
//				b_si++;
//			}
//			a_si++;
//		}
//		
//		if(b_si == b.length()) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	public static boolean checkSequence(String a,String b) {
		if(b.length() == 0) {
			return true;
		}else if(a.length() == 0) {
			return false;
		}
		if(a.charAt(a.length()-1) == b.charAt(b.length()-1)) {
			return checkSequence(a.substring(0,a.length()-1),b.substring(0,b.length()-1));
		}else {
			return checkSequence(a.substring(0,a.length()-1),b);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="abchjsgsuohhdhyrikkknddg";
		String b="coding";
		
		boolean output= checkSequence(a,b);
		System.out.print(output);
	}

}
