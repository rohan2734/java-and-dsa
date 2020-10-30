package recursion_2;

public class print_subsets_sum_to_k {
	
	public static void printSubsetsSumToK(int input[],int k,int si,int outputSoFar[]) {
		if(si <= -1) {
			if(k==0) {
				for(int i=0;i<outputSoFar.length;i++) {
					System.out.print(outputSoFar[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		//include
		int ans[] = new int[outputSoFar.length+1];
//		int i;
//		for(i=0;i<outputSoFar.length;i++) {
//			ans[i]=outputSoFar[i];
//		}
//		ans[i] = input[si];
		ans[0] = input[si];
		for(int  i=0;i<outputSoFar.length;i++) {
			ans[i+1] = outputSoFar[i];
		}
		printSubsetsSumToK(input,k-input[si],si-1,ans);
		//exclude
		printSubsetsSumToK(input,k,si-1,outputSoFar);
		
		
	}
	
	public static void printSubsetsSumToK(int input[],int k) {
		//int si=0;
		int si=input.length-1;
		int outputSoFar[] = new int[0];
		printSubsetsSumToK(input,k,si,outputSoFar);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {5,12,3,17,1,18,15,3,17};
		//int input[]= {5,3,1,3};
		int k=6;
		printSubsetsSumToK(input,k);
	}

}
