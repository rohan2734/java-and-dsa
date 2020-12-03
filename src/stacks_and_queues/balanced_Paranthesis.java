package stacks_and_queues;

import java.io.BufferedReader;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;


public class balanced_Paranthesis {

	/**
	 * @param args
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	 public static boolean isBalanced(String expression) throws StackFullException,StackEmptyException{
	        //Your code goes here
		 StackUsingArray stack = new StackUsingArray();
		 char input[] = expression.toCharArray();
		 
		 for(int i=0;i<input.length;i++){
			 if(stack.isEmpty()){
				 stack.push(input[i]);
				 continue;
			 }
				 if(stack.top() == input[i]){
					 stack.push(input[i]);
					 continue;
				 }else if(stack.top()== ')' && input[i] == '('){
					 return false;
				 }else if(stack.top() == '(' && input[i]  == ')'){
					 stack.pop();
					 continue;
				 }
			 
			 //stack.push(input[i]);
		 }
		 if(stack.isEmpty()){
			 return true;
		 }
		return false;
		 
	       
	 }
	
	  public static  boolean lecturers_isBalanced(String expression){
		  Stack<Character> stack = new Stack<Character>();
		  
		  for(int i=0;i<expression.length();i++){
			  if(expression.charAt(i) == '('){
				  stack.push(expression.charAt(i));
			  }else if(expression.charAt(i) == ')'){
				  if(stack.isEmpty()){
					  return false;
				  }
				  
				  char topChar = stack.pop();
				  
				  if(expression.charAt(i) == ')' && topChar == '('){
					  continue;
				  }else{
					  return false;
				  }
			  }
		  }
		  
		  return stack.isEmpty();
	  }
	public static void main(String[] args) throws IOException, StackFullException, StackEmptyException {
		// TODO Auto-generated method stub
		
		String expression = br.readLine().trim();
		System.out.print(expression);
		
		boolean result = isBalanced(expression);
		boolean lec_result = lecturers_isBalanced(expression);
		System.out.print(result);
	}

}
