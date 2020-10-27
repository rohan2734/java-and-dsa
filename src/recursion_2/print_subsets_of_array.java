package recursion_2;

public class print_subsets_of_array {
	
	public static void printSubsets(int input[],int si,int outputSoFar[]) {
		if(si == -1) {
			for(int i=0;i<outputSoFar.length;i++) {
				System.out.print(outputSoFar[i] +" ");
			}
			System.out.println();
			return;
		}
		printSubsets(input,si-1,outputSoFar);
		int ans[]= new int[outputSoFar.length+1];
		for(int i=0;i<outputSoFar.length;i++) {
			ans[i+1]=outputSoFar[i];
		}
		ans[0]=input[si];
		printSubsets(input,si-1,ans);
	}
//	
	public static void printSubsets(int input[]) {
		int outputSoFar[]= {};
		 printSubsets(input,input.length-1,outputSoFar);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {15,20,12};
		printSubsets(input);
//		for(int i=0;i<input.length;i++) {
//			System.out.print(input[i] +" ");
//		}
	}

}
