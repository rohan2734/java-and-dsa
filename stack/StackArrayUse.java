package stack;

public class StackArrayUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws StackFullException{
		// TODO Auto-generated method stub
		StackUsingArray stack = new StackUsingArray();
		for(int i=1;i<=10;i++){
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			try{
				System.out.println(stack.pop());
			}catch(StackEmptyException e){
				//never reach here
			}
		}
	}

}
