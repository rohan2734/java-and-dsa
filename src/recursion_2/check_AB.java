package recursion_2;

public class check_AB {
	
//	public static boolean checkAB(String input,int si) {
//		if(input.length() == si)
//	    {
//	        return true;
//	    }
//	    
//	    if(si == 0) 
//	    {
//			if(input.charAt(si) != 'a') 
//	        {
//				
//				return false;
//			}
//		}
//	    
//	    if(input.charAt(si) == 'a' ) 
//	    {
//	        return checkAB(input,si+1);
//	
//	    }
//	    
//	    if(input.length()>si+1)
//	    {
//	
//	       if(input.charAt(si+1) == 'a')
//	       {
//	           return false;
//	       }
//	        return checkAB(input,si+2);
//	    }
//	    else
//	    {
//	        return false;
//	    }
//	
//	}
	public static boolean checkAB(String input,int si) {
		if(si == input.length()) {
			return true;
		}
		if(si==0) {
			if(input.charAt(si) != 'a') {
				return false;
			}else {
				return checkAB(input,si+1);
			}
		}
		if(input.charAt(si) == 'a') {
			return checkAB(input,si+1);
		}else {
			//input.charAt(si) = 'b'
			if(si+1<input.length()) {
				if(input.charAt(si+1) == 'a') {
					return false;
				}else {
					return checkAB(input,si+2);
				}
			}else {
				return false;
			}
		}
	}
	
	public static boolean lecturers_checkAB(String str) {
		if(str.length() == 0) {
			return true;
		}
		if(str.charAt(0) == 'a') {
			if(str.substring(1).length() > 1 && str.substring(1,3).equals("bb")) {
				return lecturers_checkAB(str.substring(3));
			}else {
				return lecturers_checkAB(str.substring(1));
			}
		}
		return false;
	}
		
	public static boolean checkAB(String input) {
		return checkAB(input,0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abb";
		//String input[] = {"a","b","b"};
		boolean result = checkAB(input);
		System.out.print(result);
	}

}
