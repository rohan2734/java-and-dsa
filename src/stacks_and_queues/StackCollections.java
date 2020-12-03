package stacks_and_queues;

import java.util.Stack;

public class StackCollections {
	
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		int arr[] = {5,2,8,1};
		
		for(int i=0;i<arr.length;i++){
			stack.push(arr[i]);
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.peek());
			stack.pop();
		}
	}
	
	
	
	
	
	

}
 