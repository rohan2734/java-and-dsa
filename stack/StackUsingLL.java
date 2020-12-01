package stack;

public class StackUsingLL<T> {
	
	private Node<T> head;//by default non primitive is null
	private int size; // by default primitive is 0

	
	
	public StackUsingLL(){
		head = null;
//		reverseHead = null;
//		reverseTail = null;
		size=0;
	}
	
	int size(){
		return size;
	}
	
	T top() throws StackEmptyException{
		if(size()== 0){
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	boolean isEmpty(){
		return size() == 0;
	}
	
	void push(T element){
		Node<T> newNode = new Node<T>(element);
		newNode.next = head;
		head = newNode;
		size++;	
	}
	
	T pop() throws StackEmptyException{
		if(size() == 0){
			throw new StackEmptyException();
		}
		
			T temp=head.data;
		    head=head.next;
			
			size--;
			return temp;
			
	}
	
	
	
	
}
