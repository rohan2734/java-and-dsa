package stack;

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
	}
	
}
