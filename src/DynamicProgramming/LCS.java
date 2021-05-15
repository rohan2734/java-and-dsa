package DynamicProgramming;

public class LCS {
    
    public static int lcs(String s,String t){
        if(s.length() == 0 || t.length() == 0){
            return 0;
        }

        if(s.charAt(0) == t.charAt(0)){
            return 1 + lcs(s.substring(1),t.substring(1));
        }else{
            int op1 = lcs(s,t.substring(1));
            int op2 = lcs(s.substring(1),t);
            int op3 = lcs(s.substring(1),t.substring(1));
            return Math.max(op1,Math.max(op2,op3));
        }
        
    }

    public static int lcsM(String s,String t){
        int storage[][] = new int[s.length() + 1][t.length()+1];
        //by default 0
        //to distinguish, if values are calculated or not ,initalise with -1
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                storage[i][j] = -1;
            }
        }
        return lcsM(s, t,storage);
    }

    public static int lcsM(String s,String t,int[][] storage){
        int m=s.length();
        int n= t.length();

        if(storage[m][n]!=-1){
            return storage[m][n];
        }
        if(m==0 || n==0){
            storage[m][n]=0;
            return storage[m][n];
        }

        if(s.charAt(0) == t.charAt(0)){
            storage[m][n]=1 + lcsM(s.substring(1),t.substring(1),storage) ;
            return  storage[m][n];
        }else{
            int op1 = lcsM(s,t.substring(1),storage);
            int op2 = lcsM(s.substring(1),t,storage);
            int op3 = lcsM(s.substring(1),t.substring(1),storage);

            storage[m][n] = Math.max(op1,Math.max(op2,op3));
            return  storage[m][n];
        }


    }

    public static int lcsDP(String s,String t){
        int m = s.length();
        int n=t.length();
        int storage[][] = new int[m][n];


        for(int i=1;i<m ;i++){
            for(int j=1;j<n;j++){
                String newS = s.substring(i);
            String newT = t.substring(j);

            if(newS.charAt(m-i) == newT.charAt(j-i)){
                storage[i][j]=1 + storage[i-1][j-1];
            }else{
                int op1 = storage[i][j-1];
                int op2 = storage[i-1][j];
                int op3 = storage[i-1][j-1];
    
                storage[i][j] = Math.max(op1,Math.max(op2,op3));
            }
            }
        }

        return storage[m-1][n-1];
    }


    public static void main(String[] args) {
        String s = "agih";
        String t = "bhigh";
        System.out.println(lcsDP(s,t));

    }
}
