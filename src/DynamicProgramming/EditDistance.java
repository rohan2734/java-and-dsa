package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
	
		String str1 = br.readLine().trim();
		String str2 = br.readLine().trim();
        // System.out.println(editDistance(str1, str2));
        // System.out.println(editDistanceLecMHelper(str1,str2));
        System.out.println(editDistanceDP(str1,str2));
        
	}
    public static int editDistance(String s1, String s2){

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */        
        if(s1.length()==0 && s2.length() ==0){
            return 0;
        }
        if(s1.length() == 0 ){
            return s2.length();
        }
        if(s2.length() == 0){
            return s1.length();
        }

        int suboutput1 = Integer.MAX_VALUE;
        int suboutput2 = Integer.MAX_VALUE;
        int suboutput3 = Integer.MAX_VALUE;

        if(s1.charAt(0) == s2.charAt(0)){
            return editDistance(s1.substring(1), s2.substring(1));
        }

        //insert
        String tempS1=s1;
        tempS1 = s2.charAt(0) + s1;
        suboutput1 = editDistance(tempS1, s2);
        
       

        //delete
        tempS1 = s1;
        suboutput2 = editDistance(tempS1.substring(1), s2);
        

        //substitute
        tempS1 = s1;
        tempS1 = s2.charAt(0) + tempS1.substring(1);
        suboutput3 = editDistance(tempS1, s2);

        return 1 + Math.min(suboutput1,Math.min(suboutput2,suboutput3));
	}


    public static int editDistanceLecMHelper(String s,String t){
        int storage[][] = new int[s.length()+1][t.length()+1];

        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                storage[i][j] = -1;
            }
        }
        return editDistanceM(s, t, storage);
    }
    public static int editDistanceM(String s,String t,int storage[][]){
        int m = s.length();
        int n = t.length();

        if(storage[m][n]!=-1){
            return storage[m][n];
        }

        if(m==0){
            storage[m][n] = n;
            return storage[m][n];
        }

        if(n==0){
            storage[m][n]=m;
            return storage[m][n];
        }
        

        if(s.charAt(0) == t.charAt(0)){
            
            storage[m][n] = editDistanceM(s.substring(1), t.substring(1),storage);
            return  storage[m][n];
            
        }else{
            //insert
            int op1 = editDistanceM(s, t.substring(1),storage);

            //delete
            int op2 = editDistanceM(s.substring(1),t,storage);

            //substitute
            int op3 = editDistanceM(s.substring(1), t.substring(1),storage);
            
         
            storage[m][n] = 1 + Math.min(op1,Math.min(op2,op3));
            
            
            
        }
        return storage[m][n] ;
    }

    public static int editDistanceDP(String s,String t){
        int m=s.length();
        int n=t.length();

        int storage[][] = new int[m+1][n+ 1];
        for(int j=0;j<=n;j++){
            storage[0][j] = j;
        }
        for(int i=0;i<=m;i++){
            storage[i][0]=i;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i) == t.charAt(j)){
                    storage[i][j]=storage[i-1][j-1];
                }else{
                    //insert
                    int op1 = storage[i][j-1];

                    //delete
                    int op2 = storage[i-1][j];

                    //substitute
                    int op3 = storage[i-1][j-1];
                    
                
                    storage[m][n] = 1 + Math.min(op1,Math.min(op2,op3));
                }
            }
        }
        return storage[m][n];

    }
}

 
    

