package recursion_2;

public class return_subsets_sum_to_k {
	
	public static int[][] SubsetsSumToK(int input[],int x,int si){
		if(si==input.length) {
			int ans[][] = new int[1][0];
			if(x==0) {
				ans[0][0]= input[si-1];	
			}
			return ans;
		}
		
		int smallAns1[][]=SubsetsSumToK(input,x-input[si],si+1); //include
		int smallAns2[][]=SubsetsSumToK(input,x,si+1);
		int output[][] = new int[smallAns1.length+smallAns2.length][];
		int k=0;
		for(int i=0;i<smallAns1.length;i++) {
			output[k] = new int [smallAns1[i].length+1];
			output[k][0] = input[si];
			for(int j=0;j<smallAns1[i].length;j++) {
				output[k][j+1] =smallAns1[i][j]; 
				
			}
			k++;
		}
		for(int i=0;i<smallAns2.length;i++) {
			output[k] = new int [smallAns2[i].length+1];
			for(int j=0;j<smallAns2[i].length;j++) {
				output[k][j] =smallAns2[i][j]; 	
			}
			k++;
		}
		
		return output;
		
		
	}
	
	public static int[][] SubsetsSumToK(int input[],int x){
		int si=0;
		return SubsetsSumToK(input,x,si);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {5,12,3,17,1,18,15,3,17};
		int x = 6;
		int output[][] = SubsetsSumToK(input,x);
		for(int i=0;i<output.length;i++) {
			for(int j=0;j<output[i].length;j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

}
