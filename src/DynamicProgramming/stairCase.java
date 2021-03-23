package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class stairCase {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static long staircase(int n) {
		//Your code goes here
        if(n == 1){
            return 0;
        }
        
        long min1 =0;
        if(n-1>=1){
            min1= staircase(n-1);
        }
        

        long min2=0;
        if(n-2 >=1){
            min2 = staircase(n-2);
        }
        
        long min3=0;
        if(n-3 >=1){
            min3 = staircase(n-3);
        }
       
        return min1 + min2 + min3 +1;

	}

    
	public static long staircaseDP(int n) {
		//Your code goes here
         long storage[] = new long[n+1];
        if(n==0)
            return 1;
        if(n==1)
            return 1 ;
        if(n==2)
            return 2;
       
        storage[0]=1;
        storage[1]=1;
        storage[2]=2;

        for(int i=3;i<=n;i++){
            long totalsteps =storage[i-1]+storage[i-2]+storage[i-3];
            
           
            storage[i] = totalsteps ;
        }

        return storage[n];

	}

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(staircaseDP(n));
    }
}

