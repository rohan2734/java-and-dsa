package recursion_2;

public class print_subsets_sum_to_k {
	
//	public static int[][] getSubsets(int input,int si){
//		if(si == input.length) {
//			int ans[][]= {{}};
//			return  ans;
//		}
//		int smallAns[][] = getSubsets(input,si+1);
//	}
	
	public static int subsetsSumToK(int input[],int si,int outputSoFar,int k) {
		if(outputSoFar == k) {
			return 1;
		}
		if(outputSoFar >= k) {
			return 0;
		}
		int outputArrays[] = new int[input.length -1 -si];
		for(int i=1;i<outputArrays.length;i++) {
			outputArrays[0] = subsetsSumToK(input,si+i,outputSoFar)
		}
	}
	
	public static int subsetsSumToK(int input[],int k) {
		int outputSoFar=0,si=0;
		return subsetsSumToK(input,si,outputSoFar,k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {5,12,3,17,1,18,15,3,17};
		int x = 6;
		int output=subsetsSumToK(input,k);
	}

}
