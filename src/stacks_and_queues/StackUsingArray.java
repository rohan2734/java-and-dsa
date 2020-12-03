package stacks_and_queues;

public class StackUsingArray {
	private int data[];
	private int top; //is the index of topmost element of stack
	
	public StackUsingArray(){
		data = new int[10];
		top = -1;
	}
	
	public StackUsingArray(int capacity){
		data = new int[capacity];
		top = -1;
	}
	
	public  boolean isEmpty(){
		return ( top == -1);
		//order(1)
	}
	
	public int size(){
		return top + 1;
		//order(1)
	}
	
	public int top() throws StackEmptyException{
		if(size() == 0){
			//stackEmptyException
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[top];
		//order(1)
	}
	public void doubleCapacity(){
		if(size() == data.length){
			 //stack Full
			int temp[]= data;
			data = new int[2*temp.length];
			for(int i=0;i<= top;i++){
				data[i]=temp[i];
			}
		}
	}
	
	public void push(int element) throws StackFullException{
//		if(size() == data.length){
//			 //stack Full
//			StackFullException e = new StackFullException();
//			throw e;
//		}
		doubleCapacity();
		
		top+=1;
		data[top]=element;
	}
	
	public int pop() throws StackEmptyException{
		if(size() == 0){
			//stackEmptyException
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		int temp= data[top];
		top-=1;
		return temp;
	}
	
}
