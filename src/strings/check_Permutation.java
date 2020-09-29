package strings;

public class check_Permutation {
	public static boolean checkPermutation(String input1,String input2) {
		int i=0;
		boolean isValid=true;
		int[] count= new int[256];
		boolean[] isFound=new boolean[input1.length()];
		while(i<input2.length()) {
			count[input2.charAt(i)]+=1;
			i++;
		}
		i=0;
		while(i<input1.length()){
			int j=0;
			isFound[i]=false;
			while(j<input2.length()) {
				if(input1.charAt(i) == input2.charAt(j) && count[input2.charAt(j)]>0) {
					count[input2.charAt(j)]--;
					isFound[i]=true;
					break;
				}
				j++;
			}	
			if(!isFound[i]) {
				isValid=false;
				break;
			}
			i++;
		}
		return isValid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcdcba";
		System.out.print(checkPermutation("aba","bab"));
	}

}
