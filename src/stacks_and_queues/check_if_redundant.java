package stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class check_if_redundant {

	/**
	 * @param args
	 */
	
	public static boolean checkReduntant(String expression) throws StackEmptyException,StackFullException{
		char[] input = expression.toCharArray();
		
		int count=0;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<input.length;i++){
			count=0;
			while( i< input.length && input[i] != ')' ){
				//stack.add(input[i]);
				stack.add(input[i]);
//				count++;
				i++;
			}
			while(stack.peek() != '('){
				stack.pop();
				count++;
			}
			
			if(count == 0 || count == 1){
				return true;
			}else{
				stack.pop();
				
			}
		}
		return false;
	}
	public static void main(String[] args) throws StackEmptyException,StackFullException{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String expression= s.nextLine();
		
		boolean result  = checkReduntant(expression);
		System.out.print(result);
		
	}

}
