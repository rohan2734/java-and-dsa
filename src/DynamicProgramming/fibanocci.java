package DynamicProgramming;

public class fibanocci {
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }

        return fib(n-1) + fib(n-2);
    }  
    //an array to store the fib(n),fib(n-1)...fib(0)
    //fib(0) at 0, fib(1) at 1,... fib(n) at n
    public static int  fibM(int n){
        int storage[] = new int[n +1];
        for(int i=0;i<=n;i++){
            storage[i]=-1;
        }
        return fibM(n,storage);
    }

    public static int fibM(int n,int storage[]){
        if(n==0||n==1){
            storage[n]=n;
            return storage[n];
        }

        if(storage[n] != -1){
            return storage[n];
        }

        storage[n]= fibM(n-1,storage) + fibM(n-2,storage);
        return storage[n];
    }
    //here we are following top down approach
    //and memoisation
    //we are making the time complexity to O(n)
    //number of calls are 2*n-1
    //but space complexity is increased

    public static int fibDP(int n){
        int storage[] = new int[n+1];

        storage[0]=0;
        storage[1]=1;

        for(int i=2;i<=n;i++){
            storage[i]=storage[i-1]+storage[i-2];
        }

        return storage[n];
        //we are trying and eliminating recursion
    }
    //problem was overlapping subproblems
    //we were doing redundant work
    

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));
        System.out.println(fibM(n));
    }
}
