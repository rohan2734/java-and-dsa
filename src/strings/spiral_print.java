package strings;

public class spiral_print {
	
	public static void spiralPrint(int mat[][]) {
		int lrow=mat.length;
		int lcol=mat[0].length;

		int rs=0,re=lrow-1,cs=0,ce=lcol-1;
		int count=0;
		while(count<lrow*lcol) {
			int i=cs,j=rs;
			while(i<=ce) {
				System.out.print(mat[j][i]+" ");
				count++;
				i++;
			}
			rs++;
			i=rs;j=ce;
			while(i<=re) {
				System.out.print(mat[i][j]+" ");
				count++;
				i++;
			}
			ce--;
			i=ce;j=re;
			while(i>=0 && i>=cs) {
				System.out.print(mat[j][i]+" ");
				count++;
				i--;
			}
			re--;
			i=re;j=cs;
			while(i>=0 && i>=rs) {
				System.out.print(mat[i][j]+" ");
				count++;
				i--;
			}
			cs++;
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][]= {{1,2,3},{4,5,6},{7,8,9}};
		spiralPrint(mat);
	}

}
