//weights: (in kgs)
//values:

//theif has bag, and maximum limit
//bag limit-> 5kg
//carry maximum value items

//maximum value that can be achieved, limit is 5kg

//



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class knapsackQuestion{

    public static int knapsackHelper(int[] weights, int[] values, int n, int maxWeight,int i){
        if(i >= n || maxWeight == 0){
            return 0;
        }
        int op1 = 0;
        int op2=0;
        int op3=0;
        if(weights[i]> maxWeight){
            op1 = knapsackHelper(weights,values,n,maxWeight,i+1);
        }else{
            op2 = values[i] + knapsackHelper(weights,values,n,maxWeight-weights[i],i+1);
        
            op3 =  + knapsackHelper(weights,values,n,maxWeight,i+1);
        }
       
       

        return Math.max(op1,Math.max(op2,op3));
    }
    public static int knapsackMemoHelper(int[] weights,int[] values,int n,int maxWeight,int i,int[][] storage){
        if(i >= n || maxWeight == 0){
            storage[maxWeight][i]=0;
            return storage[maxWeight][i];
        }
        int op1 = 0;
        int op2=0;
        int op3=0;
        if(weights[i]> maxWeight){
            op1 = knapsackHelper(weights,values,n,maxWeight,i+1);
            
        }else{
            op2 = values[i] + knapsackHelper(weights,values,n,maxWeight-weights[i],i+1);
            
            op3 =  + knapsackHelper(weights,values,n,maxWeight,i+1);
        }
       
       
        storage[maxWeight][i]=Math.max(op1,Math.max(op2,op3));
        return storage[maxWeight][i];
    }
    public static int knapsackMemo(int[] weights,int[] values,int n,int maxWeight){
        int storage[][] = new int[maxWeight+1][n+1];

        return knapsackMemoHelper(weights,values,n,maxWeight,0,storage);
    }
    public static int knapsackDP(int[] weights, int[] values, int n, int maxWeight) {
        int storage[][] = new int[n+1][maxWeight+1];

        for(int w = 0;w<=maxWeight;w++){
            storage[0][w]=0;
        }
        for(int k=0;k<=n;k++){
            storage[k][0]=0;
        }
        for(int k=1;k<=n;k++){
            for(int w=1;w<=maxWeight;w++){
                int op1 = 0;
                int op2=0;
                int op3=0;
                if(weights[k-1]> w){
                   // op1 = knapsackHelper(weights,values,n,maxWeight,i+1);
                    op1= storage[k-1][w];
                }else{
                    // op2 = values[k] + knapsackHelper(weights,values,n,maxWeight-weights[i],i+1);
                    op2 = values[k-1]+  storage[k-1][maxWeight-weights[k-1]];//taking
                    // op3 =  + knapsackHelper(weights,values,n,maxWeight,i+1);
                    op3 = storage[k-1][w]; //nottaking
                }
            
            
                storage[k][w]=Math.max(op1,Math.max(op2,op3));
            }
           
        }
        return storage[n][maxWeight];
    }
    
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		//Your code goes here
        //recursion //return knapsackHelper(weights,values,n,maxWeight,0);
        //memoisation //  return knapsackMemo(weights,values,n,maxWeight);
        //DP
        return knapsackDP(weights,values,n,maxWeight);

	}

    
    public static class Input {
	private int n;
	private int[] weights;
	private int[] values;
	private int maxWeight;

	public Input(int[] weights, int[] values, int n, int maxWeight) {
            this.n = n;
            this.weights = weights;
            this.values = values;
            this.maxWeight = maxWeight;
        }

        public int getSize() {
            return this.n;
        }

        public int[] getWeights() {
            return this.weights;
        }

        public int[] getValues() {
            return this.values;
        }

        public int getMaxWeight() {
            return this.maxWeight;
        }
    }

   

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Input takeInput() throws NumberFormatException, IOException {
		
		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return (new Input(new int[0], new int[0], 0, 0));
		}

		String[] strWeights = br.readLine().trim().split(" ");
		String[] strValues = br.readLine().trim().split(" ");
		int maxWeight = Integer.parseInt(br.readLine().trim());

		int[] weights = new int[n];
		int[] values = new int[n];

		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(strWeights[i]);
			values[i] = Integer.parseInt(strValues[i]);
		}

		return (new Input(weights, values, n, maxWeight));

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        Input input = takeInput();

        int n = input.getSize();
        int[] weights = input.getWeights();
        int[] values = input.getValues();
        int maxWeight = input.getMaxWeight();

        
        System.out.println(knapsack(weights, values, n, maxWeight));
    }


}
