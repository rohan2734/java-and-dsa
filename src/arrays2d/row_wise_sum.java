package arrays2d;

public class row_wise_sum {
	
	public static void rowWiseSum(int[][] mat) {
		for(int i=0;i<mat.length;i++) {
			int sum=0;
			for(int j=0;j<mat[i].length;j++) {
				sum+=mat[i][j];
			}
			System.out.print(sum + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[][] = new int[4][2];
		int mat[][] = {{1,2},{3,4},{5,6},{7,8}};
		rowWiseSum(mat);
	}

}
