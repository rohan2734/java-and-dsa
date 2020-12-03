package stacks_and_queues;

public class StackLLUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws StackEmptyException{
		// TODO Auto-generated method stub
		StackUsingLL<Integer> stack = new StackUsingLL<Integer>();
		
		for(int i=1;i<=5;i++){
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			try{
				System.out.println(stack.pop());
			}catch(StackEmptyException e){
				
			}
		}
	}

}
