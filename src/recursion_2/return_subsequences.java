package recursion_2;

public class return_subsequences {
	
	public static String[] findSubsequences(String str) {
		
		if(str.length() == 0) {
			String ans[] = {""};
			return ans;
		}
		
		String smallAns[] = findSubsequences(str.substring(1));
		String ans[] = new String[2*smallAns.length];
		
		int k=0; 
		for(int i=0;i<smallAns.length;i++) {
			ans[k] = smallAns[i];
			k++;
		}
		for(int i=0;i<smallAns.length;i++) {
			// ans[i+smallAns.length]
			ans[k] =  str.charAt(0) +  smallAns[i];
			k++;
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="xyz";
		String ans[] = findSubsequences(str);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}

}
