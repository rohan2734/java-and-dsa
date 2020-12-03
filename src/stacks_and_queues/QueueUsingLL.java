package stacks_and_queues;

public class QueueUsingLL<T>{

	private Node<T> front;
	private Node<T> rear;
	int size;
	
	public QueueUsingLL(){
		front = null;
		rear = null;
		size = 0;
	}
	
	int size(){
		return size;
	}
	boolean isEmpty(){
		return size == 0;
	}
	T front() throws QueueEmptyException{
		if(size == 0){
			throw new QueueEmptyException();
		}
		
		return front.data;
		
	}
	
	void enqueue(T element){
		Node<T> newNode = new Node<T>(element);
		if(front == null && rear == null){
			front =newNode;
			rear = newNode;
		
		}else{
			rear.next = newNode;
			rear = newNode;
			
		}	
		size++;
	}
	
	T dequeue() throws QueueEmptyException{
		if(size() == 0){
			throw new QueueEmptyException();
		}
		T temp =front.data;
		front=front.next;
		if(front == null){
			rear = null;
		}
		size--;
		return temp;
	}
	void reverse(T element){
		Node<T> newNode = new Node<T>(element);
		if(rear == null && front == null){
			rear= newNode;
			front=newNode;
			
		}else{
			newNode.next = rear;
			rear= newNode;
		}
		//size++
	}
	  void switchFrontAndRear() throws QueueEmptyException{
		  T element = front();
          Node<T> temp = new Node<T>(element);
          temp=front;
          front=rear;
          rear=temp;
      }
	
	
	
}