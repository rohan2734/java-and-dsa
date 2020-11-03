package recursion_2;

public class return_permutations {
	
	public static int returnFactorial(int x) {
		if(x==1 || x==0) {
			return x;
		}
		int ans=x;
		int smallAns =  returnFactorial(x-1);
		return ans*smallAns;
	}
	
	public static String[] permutationOfString(String input) {
		if(input.length() == 2) {
			String ans[] = new String[2];
			ans[0]= input.substring(0);
			ans[1]=String.valueOf(input.charAt(1))+ String.valueOf(input.charAt(0));;
			return ans;
		}
		if(input.length() == 0 ) {
			String ans[]= {""};
			return ans;
		}
		if(input.length() == 1) {
			String ans[] = new String[1];
			ans[0] = String.valueOf(input.charAt(0));
			return ans;
		}
		String output[] = new String[returnFactorial(input.length())];
		if(input.length()>=3) {
			int k=0;
			for(int si=0;si<input.length();si++) {
				char firstChar = input.charAt(si);
				String remainingInput = input.substring(0,si) + input.substring(si+1);
				
				String smallAns[] = permutationOfString(remainingInput);
				for(int i=0;i<smallAns.length;i++) {
					output[k] = firstChar + smallAns[i];
					k++;
				}
			}
		}
		return output;
	}
	
	public static String[] permutationOfString2(String input) {
		if(input.length() == 2) {
			String ans[] = new String[2];
			ans[0]= input.substring(0);
			ans[1]=String.valueOf(input.charAt(1))+ String.valueOf(input.charAt(0));;
			return ans;
		}
		if(input.length() == 0 ) {
			String ans[]= {""};
			return ans;
		}
		if(input.length() == 1) {
			String ans[] = new String[1];
			ans[0] = String.valueOf(input.charAt(0));
			return ans;
		}
		String output[] = new String[returnFactorial(input.length())];
		int k=0;
		if(input.length() >= 3) {
			char firstChar = input.charAt(0);
			

			String smallAns[]= permutationOfString2(input.substring(1));
			for(int j=0;j<smallAns.length;j++) {
				String smallInput2=smallAns[j];
				for(int i=0;i<=smallInput2.length();i++) {
					String remAns= smallInput2.substring(0,i) + String.valueOf(firstChar) + smallInput2.substring(i);
					output[k] = remAns;
					k++;
				}
			}
			
			
			
		}
		
		return output;
	}
	public static String[] lecturers_perm(String input) {
		if(input.length() == 0) {
			String ans[] = {""};
			return ans;
		}
		String[]  smallerOutput = lecturers_perm(input.substring(1));
		
		String output[] = new String[input.length()*smallerOutput.length];
		
		int k=0;
		for(int i=0;i<smallerOutput.length;i++) {
			String currentString = smallerOutput[i];
			for(int j=0;j <= currentString.length(); j++) {
				output[k] = currentString.substring(0,j) + input.charAt(0) + currentString.substring(j);
				k++;
			}
		}
		
		return output;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="abcd";
		String output[]=permutationOfString2(input);
		for(int i=0;i<output.length;i++) {
			System.out.println(output[i].substring(0));
		}
		
/
		
	}

}
