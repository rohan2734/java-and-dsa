package recursion_2;

public class subsets_of_array_recursion {
	
	 public static int[][] subsets(int input[],int si){
			if(si == input.length) {
				int ans[][]= new int[1][0];
				return ans;
			}
			
			int smallAns[][] = subsets(input,si+1);
			int ans[][] = new int[smallAns.length*2][];
			int k=0;
			for(int i=0;i<smallAns.length;i++) {
	            ans[k]=new int[smallAns[i].length];
				for(int j=0;j<smallAns[i].length;j++) {
					ans[k][j] =smallAns[i][j]; 	
				}
				k++;
			}
			for(int i=0;i<smallAns.length;i++) {
	         ans[k]=new int[smallAns[i].length+1];

				ans[k][0]=input[si];
				for(int j=0;j<smallAns[i].length;j++) {
					ans[k][j+1] = smallAns[i][j]; 
				}
				k++;
			}
			return ans;
			
			
			
		}
	public static int[][] subsets(int input[]){
		int si=0;
		
		
		//return subsets(input,si);
		int output[][]=subsets(input,si);
//		for(int i=0;i<output.length;i++) {
//			for(int j=0;j<output[0].length;j++) {
//				System.out.print(output[i][j] +" ");
//			}
//			System.out.println();
//		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {15,20,12};
		int output[][] = subsets(input);
		int col=output[0].length;
		int row=output.length;
		for(int i=0;i<output.length;i++) {
			for(int j=0;j<output[i].length;j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

}
