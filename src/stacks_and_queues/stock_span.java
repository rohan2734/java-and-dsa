package stacks_and_queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.EmptyStackException;


public class stock_span {
	
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    public static int[] takeInput() throws NumberFormatException, IOException {
	    	int size = Integer.parseInt(br.readLine().trim());
	    	int[] input = new int[size];

	    	if (size == 0) {
	    		return input;
	    	}

	    	String[] values = br.readLine().trim().split(" ");

	    	for(int i = 0; i < size; i++) {
	    		input[i] = Integer.parseInt(values[i]);
	    	}

	    	return input;
	    }

	    public static void printArray(int[] arr) {
	    	for (int i = 0 ; i < arr.length; i++) {
	    		System.out.print(arr[i] + " ");
	    	}

	    	System.out.println();
	    }
	    public static int[] stockSpan(int[] input) {
			//Your code goes here
	    	int[] output = new int[input.length];
	    	for(int i=input.length-1;i>=0;i--){
	    		int j=i-1;
	    		int count=1;
	    		while(j>=0 && input[i] > input[j]){
	    			count++;
	    			j--;
	    		}
	    		output[i]=count;
	    	}
	    	
	    	return output;
	    	
		}
		public static int[] stockSpan2(int[] input) throws EmptyStackException{
			
			 Stack<Integer> stack = new Stack<Integer>();
			 int[] output = new int[input.length];
			 stack.push(0);
			 output[0]=1;
			 for(int i=1;i<input.length;i++){
				 while(!stack.isEmpty()&&input[stack.peek()]<input[i]){
					 stack.pop();
				 }
				 if(stack.isEmpty()){
					 output[i] = i+1;
				 }
				 else{
					 output[i] = i -stack.peek();
				 }
				 stack.push(i);
			}
		
	        
	        return output;
		}

	
	public static void main(String[] args) throws NumberFormatException, IOException,EmptyStackException{
		// TODO Auto-generated method stub
		
		int[] input = takeInput();

    	int[] output = stockSpan2(input);

    	printArray(output);


	}

}
