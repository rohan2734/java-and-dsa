package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class min_cost_path {
    public static int minCostPath(int[][] input) {
		//Your code goes here
        return minCostPath(0,0,input);
        
	}

    public static int minCostPath(int i,int j,int[][] input) {
		//Your code goes here
        if(i==input.length-1 && j==input[0].length-1 ){
            return input[i][j];
        }
        int result1 =Integer.MAX_VALUE;
        if(j+1 < input[0].length){
            result1 = minCostPath(i, j+1, input);
        }
        int result2=Integer.MAX_VALUE;
        if(i+1<input.length && j+1 < input[0].length ){
            result2 = minCostPath(i+1, j+1, input);
        }
        int result3=Integer.MAX_VALUE;
        if(i+1 < input.length){
            result3 = minCostPath(i+1, j, input);
        }

        return input[i][j] + Math.min(result1, Math.min(result2 ,result3));
         
        
	}

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums; 
            strNums = br.readLine().trim().split("\\s");
            
            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(minCostPath(mat));
    }
}
