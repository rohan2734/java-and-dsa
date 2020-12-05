package stacks_and_queues;

import java.util.Scanner;
import java.util.Stack;

public class count_Bracket_reversals {

	/**
	 * @param args
	 */
	
	public static int countBracketReversals(String input) throws EmptyStackException{
		//Your code goes here
		char[] charInput = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		if(input.length()%2!=0){
			return -1;
		}
		int count = 0;
		for(int i=0;i<charInput.length;i++){
			while(i<charInput.length && charInput[i] == '{'){
				stack.add('{');
				i++;
			}
			
			while(i<charInput.length && charInput[i]  == '}' && !stack.isEmpty()){
				stack.pop();
				i++;
			}
			if(i< charInput.length && stack.isEmpty() && charInput[i] == '}' ||i< charInput.length && !stack.isEmpty() && charInput[i] == '}'){
				stack.add('}');
				i++;
			}
			
		}
		while(!stack.isEmpty()) {
			char c1 = stack.pop();
			char c2 = stack.pop();
			if(c1 == '{' && c2 == '}'){
				count+=2;
			}else if(c1 == c2){
				count++;
			}
		}
		return count;
		
		
		
		
	}
	public static void main(String[] args) throws EmptyStackException{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int output = countBracketReversals(input);
		System.out.print(output);
	}

}
