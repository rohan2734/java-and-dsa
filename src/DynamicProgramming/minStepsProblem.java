package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class minStepsProblem {
    public static int countMinStepsToOne(int n){
        if(n==1){
            return 0;
        }

        int option1Steps = countMinStepsToOne(n-1);

        if(n%3 == 0){
            int option2Steps = countMinStepsToOne(n/3);

            if(option2Steps < option1Steps){
                option1Steps = option2Steps;
            }

        }

        if(n%2 == 0){
            int option3Steps = countMinStepsToOne(n/2);

            if(option3Steps < option1Steps){
                option1Steps = option3Steps;
            }
        }

        return 1+ option1Steps;
        
    }

    // public static int minSteps(int n,int minSteps){
    //     if(n==1){
    //         return 0;
    //     }

    //     int option1Steps = minSteps(n-1);

    //     if(n%2 == 0){
    //         int option2Steps = minSteps(n%2);

    //         if(option2Steps < option1Steps){
    //             option1Steps = option2Steps;
    //         }

    //     }

    //     if(n%3 == 0){
    //         int option3Steps = minSteps(n%3);

    //         if(option3Steps < option1Steps)
    //     }
    // }

    static int countStepsM(int n){
        int storage[] = new int[n+1];
        return countStepsM(n,storage);
    }

    public static int countStepsM(int n,int storage[]){
        if(n==1){
            storage[n]=0;
            return storage[n];
        }
        if(storage[n]!=0){
            return storage[n];
        }
        
        int option1Steps = countStepsM(n-1,storage);

        if(n%3 == 0){
            int option2Steps = countStepsM(n/3,storage);

            if(option2Steps < option1Steps){
                option1Steps = option2Steps;
            }

        }

        if(n%2 == 0){
            int option3Steps = countStepsM(n/2,storage);

            if(option3Steps < option1Steps){
                option1Steps = option3Steps;
            }
        }
        storage[n] = 1+ option1Steps;
        return 1+ option1Steps;
    }
    

    public static int countStepsDP(int n){
        int storage[] = new int[n+1];

        storage[1]=0;
        if(n==1){
            return storage[1];
        }

        for(int i=2;i<=n;i++){
            int min = storage[i-1];

            if(i%3 == 0){
                int op2 = storage[i/3];
                if(op2 < min){
                    min = op2;
                }
            }


            if(i%2 == 0){
                int op3 = storage[i/2];
                if(op3 < min){
                    min = op3;
                }
            }

            storage[i] = 1 + min;

        }

        return storage[n];
    }

   

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(countStepsDP(n));
    }
}
