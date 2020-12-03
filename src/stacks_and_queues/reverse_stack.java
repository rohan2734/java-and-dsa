package stacks_and_queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class reverse_stack {

	/**
	 * @param args
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Stack<Integer> takeInput() throws NumberFormatException, IOException {
    	int size = Integer.parseInt(br.readLine().trim());
    	Stack<Integer> input = new Stack<Integer>();

    	if (size == 0) {
    		return input;
    	}
    	
    	String[] values = br.readLine().trim().split(" ");

    	for(int i = 0; i < size; i++) {
    		input.push(Integer.parseInt(values[i]));
    	}

    	return input;
    }
    
    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
    	//Your code goes here
        if(input.size()<=1){
            return;
        }
        Stack <Integer> temp1 = new Stack<Integer>();
    	// Stack <Integer> temp2 = new Stack<Integer>();
    	
    	while(!input.isEmpty()){
    		extra.push(input.pop());
    	}
    	while(!extra.isEmpty()){
    		temp1.push(extra.pop());
    	}
    	while(!temp1.isEmpty()){
    		input.push(temp1.pop());
    	}
    	
    	
    	
	}
    
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Stack<Integer> input = takeInput();
    	Stack<Integer> empty = new Stack<Integer>();

    	reverseStack(input, empty);

    	while(!input.isEmpty()) {
    		System.out.print(input.pop() + " ");
    	}
		
	}

}
