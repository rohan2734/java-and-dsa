package test2;

public class print_2d_Array {
	public static void print2DArray(int input[][]) {
		int lrow=input.length;
		int lcol=input[0].length;
		for(int i=0;i<lrow;i++) {
			for(int k=lrow-i;k>0;k--) {
				for(int j=0;j<lcol;j++) {
					System.out.print(input[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
		print2DArray(mat);
	}

}
