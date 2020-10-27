package recursion_2;

public class print_subsequences {
	
	public static void printSubsequences(String input,String outputSoFar) {
		if(input.length() == 0) {
			System.out.println(outputSoFar);
			return;
		}
		//exclude first char
		printSubsequences(input.substring(1),outputSoFar);
		//include first char
		printSubsequences(input.substring(1),outputSoFar+input.charAt(0));
		
	}
	
	public static void printSubsets(int input[],int si,int outputSoFar[]) {
		if(si == input.length) {
			for(int i : outputSoFar) {
				System.out.print(i+" ");
			}
			System.out.println();
            return;
		}
		
		int ans[]= new int[outputSoFar.length+1];
		int count=0;
        for(int i=0;i<outputSoFar.length;i++) {
			ans[i]=outputSoFar[i];
            count++;
		}
		ans[count]=input[si];
		printSubsets(input,si+1,outputSoFar);
        printSubsets(input,si+1,ans);
	}
	public static void printSubsequences(String input) {
		printSubsequences(input,"");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="xyz";
		printSubsequences(input);
	}

}
