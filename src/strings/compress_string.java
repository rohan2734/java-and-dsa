package strings;

public class compress_string {
	public static String compressString(String str) {
		int i=0,j=0;
		String s="";
		
		while(i<str.length() && j<str.length()) {
			//System.out.println("i9:" + i);
			if(i==j) {
				//System.out.println("i11:+ "+i+" j11: "+j);
				j++;
			}else if(j<str.length() && str.charAt(i) == str.charAt(j) ) {
				j++;
			}else if(j<str.length()+1){
				if(j-i>1) {
					s+=str.charAt(i)+Integer.toString(j-i);
				}else {
					//System.out.print("i: "+i);
					s+=String.valueOf(str.charAt(i));
				}
				//System.out.println(" i: "+i + " j: "+j);
				//System.out.print(s.substring(0));
				i=j;
				
			}
			
		}
		if(j-i>1) {
			s+=str.charAt(i)+Integer.toString(j-i);
		}else {
			s= s+str.charAt(i);
		}
		
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaabbccdsaa";
		String str=compressString(s);
		System.out.print(str.substring(0));
	}

}
