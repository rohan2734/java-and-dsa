package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class min_cost_path {
    public static int minCostPath(int[][] input) {
		//Your code goes here
        // return minCostPath(0,0,input);
        // int storage[][]= new int[input.length][input[0].length];
        // return minCostPath(0,0,input,storage);
        return minCostPathDP(input);
        
	}
    //wrong
    public static int minCostPathDP(int[][] input){
        int storage[][] = new int[input.length][input[0].length];
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[i].length;j++){
                storage[i][j] =-1;
            }
        }
        
        storage[input.length-1][input[0].length-1] = input[input.length-1][input[0].length-1];
        for(int i=input.length-1;i>=0;i--){
            for(int j=input[0].length-1;j>=0;j--){
                if(storage[i][j]!=-1){
                    continue;
                }
                int res1=Integer.MAX_VALUE;
                
                if(i -1 >=0){
                    res1= input[i-1][j];
                }
                int res2=Integer.MAX_VALUE;
                if(j -1 >=0){
                    res2= input[i][j-1];
                }
                int res3=Integer.MAX_VALUE;
                if(i -1 >=0 && j-1>=0){
                    res3= input[i-1][j-1];
                }

                storage[i][j] = input[i][j] + Math.min(res1, Math.min(res2,res3));
            }
        }

        return storage[0][0];
    }

    public static int minCostPath(int i,int j,int[][] input,int[][] storage) {
		//Your code goes here
        if(i==input.length-1 && j==input[0].length-1 ){
            storage[i][j]=input[i][j];
            return input[i][j];
        }
        int result1 =Integer.MAX_VALUE;
        if(j+1 < input[0].length){
            if(storage[i][j+1]!=0){
                result1 =  storage[i][j+1];
            }else{
                
               result1= minCostPath(i, j+1, input,storage);
               storage[i][j+1]= result1;
            }
            return result1;
            
            
        }
        int result2=Integer.MAX_VALUE;
        if(i+1<input.length && j+1 < input[0].length ){
            if(storage[i+1][j+1]!=0){
                result2 =  storage[i+1][j+1];
            }else{
                
                result2= minCostPath(i+1, j+1, input,storage);
               storage[i+1][j+1]= result2;
            }
            return result2;
        }
        int result3=Integer.MAX_VALUE;
        if(i+1 < input.length){
            if(storage[i+1][j]!=0){
                result3 =  storage[i+1][j];
            }else{
                result3= minCostPath(i+1, j, input,storage);
               storage[i+1][j]= result3;
            }
            return result3;
        }

        return input[i][j] + Math.min(result1, Math.min(result2 ,result3));
         
        
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
