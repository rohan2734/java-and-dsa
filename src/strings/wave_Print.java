package strings;

public class wave_Print {
	public static void wavePrint(int mat[][]) {
		int lrow=mat.length;
		int lcol;
		if(lrow == 0) {
			lcol=0;
			System.out.print(0);
		}else {
			lcol=mat[0].length;
		}
		
		int j=0,i=0;
		for(j=0;lcol>0 && j<lcol;j++) {
			if(j%2==0) {
				for(i=0;lrow>0 && i<lrow;i++) {
					System.out.print(mat[i][j]+" ");
				}
			}else {
				for(i=lrow-1;lrow>0 && i>=0;i--) {
					System.out.print(mat[i][j]+" ");
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int mat[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int mat[][]= {};
		wavePrint(mat);
	}

}
