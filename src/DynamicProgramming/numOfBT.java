package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numOfBT {
    // public static long balancedBTs(long n){

	// 	/* Your class should be named Solution
	// 	 * Don't write main().
	// 	 * Don't read input, it is passed as function argument.
	// 	 * Return output and don't print it.
	//  	 * Taking input and printing output is handled automatically.
    //     */
    //     if(n==1 || n==0){
    //         return 1;
    //     }

    //     long count=0;
    //     long leftC = balancedBTs(n-1);
    //     long rightC = balancedBTs(n-1);
    //     count+= Math.max(leftC,rightC);

    //     leftC = balancedBTs(n-2);
    //     rightC = balancedBTs(n-1);
    //     count+= Math.max(leftC,rightC);

    //     leftC = balancedBTs(n-1);
    //     rightC = balancedBTs(n-2);
    //     count+= Math.max(leftC,rightC);

    //     return count;

	// }

    public static int countBalancedBTs(int h){
        int mod = (int)Math.pow(10,9)+7;
        return countBalancedBTs(h,mod);
    }

    public static int countBalancedBTs(int h,int mod){

        if(h==0 || h==1){
            return 1;
        }
        //h=1, return 2 right?

        int x = countBalancedBTs(h-1);
        int y = countBalancedBTs(h-2);

        long res1= (long)x*x;
        long res2 = (long)x*y*2;

        int value1= (int)(res1 % mod);
        int value2 = (int)(res2 * mod);
        return (value1 +value2 ) % mod ;
	}

    public static int balancedBTs(int h){
        int storage[] = new int[h+1];
        storage[0]=1;
        storage[1]=2;

        for(int i=2;i<=h;i++){
            int x= storage[i-1];
            int y= storage[i-2];

            storage[i] = x*x + 2*x*y;
        }

        return storage[h];
    }

    public static int balancedBTsDP(int h){
        int mod =(int) Math.pow(10,9)+7;
        return balancedBTsDP(h,mod);
    }

	public static int balancedBTsDP(int h,int mod){

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        if(h==0 || h==1){
            return 1;
        }
        int storage[] = new int[h+1];
        storage[0]=1;
        
        storage[1]=1;

        for(int i=2;i<=h;i++){
            long x= storage[i-1];
            long y= storage[i-2];
            
            int res1= (int)((x*x)%mod);
            int res2 =(int) ((2*(x*y))%mod);
            
            int res3 = (res1 + res2 )%mod;

            storage[i] = res3;
        }

        return storage[h];

		
        
        
        
	}
  

    

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws NumberFormatException, IOException {


        int n = Integer.parseInt(br.readLine().trim());
        System.out.print(countBalancedBTs(n));


    }
}
