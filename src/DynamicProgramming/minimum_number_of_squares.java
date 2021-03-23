package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class minimum_number_of_squares {
    // public static int minCount(int n) {
	// 	//Your code goes here
    //     if(n==0){
    //         return 0;
    //     }

    //     int min=Integer.MAX_VALUE;
        
    //     for(int i=1;i<= Math.sqrt(n);i++){
    //         int count=0;
    //         int new_n = n - i*i;
    //         count = minCount(new_n);
            

    //         if(min > count){
    //             min =count;
    //         }
    //     }

    //     return min+1;


	// }

    public static int minCount(int n){
        int storage[] = new int[n+1];
        return minCountM(n,storage);
    }

    public static int minCountM(int n,int storage[]) {
		//Your code goes here
        if(n==0){
            storage[0]=0;
            return 0;
        }

        int min=Integer.MAX_VALUE;
        
        for(int i=1;i<= Math.sqrt(n);i++){
            int count=0;
            int new_n = n - i*i;
            if(storage[new_n]==0){
                count = minCountM(new_n,storage);
            }else{
                count = storage[new_n];
            }
           
            

            if(min > count){
                min =count;
            }
        }
        storage[n] = min+1;
        return storage[n];


	}

    public static int minCountDP(int n){
        int storage[] = new int[n+1];
        storage[0]=0;
        storage[1]=0;
        for(int i=3;i<= n ;i++){
            int j=(int)Math.sqrt(i);
            storage[i] = 1 + storage[i-j*j];

            int min=0;
            for(int x=0;x<j;x++){
                min = 1 + storage[i-x*x];
                if(min < storage[i]){
                    storage[i]=min;
                }
            }
        }

        return storage[n];

        
        
    }



    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(minCount(n));
    }


}
