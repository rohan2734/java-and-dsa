package arrays2d;

public class find_largest_row_or_col_by_sum {
	
	public static void findLargest(int[][] mat) {
		int largestSum=-Integer.MAX_VALUE-1;
		boolean byRow=false;
		boolean byCol=false;
		int row=0;
		int col=0,i=0,j=0;
		for( i=0;i<mat.length;i++) {
			int sum=0;
			for( j=0;j<mat[i].length;j++) {
				sum+=mat[i][j];
			}
			if(sum>largestSum) {
				largestSum=sum;
				byRow=true;
				byCol=false;
				row=i;
			}
			sum=0;
			for( j=0;j<mat.length;j++) {
				System.out.println("i:"+ i +"j "+j );
				sum+=mat[j][i];
				System.out.println("sum: "+sum);
			}
			System.out.println("largestSum: "+largestSum);
			if(sum>largestSum) {
				largestSum=sum;
				
				byRow=false;
				byCol=true;
				col=j;
			}
		}
		if(byRow) {
			System.out.print("row "+row+" "+largestSum);
		}else {
			System.out.print("column "+col+" "+largestSum);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int mat[][] = {{1,1},{1,1}};
		int mat[][] = {{3,6,9},{1,4,7},{2,8,9}};
		findLargest(mat);

	}

}
