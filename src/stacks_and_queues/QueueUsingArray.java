package stacks_and_queues;

public class QueueUsingArray {
	private int data[];
	private int front; // index at which front element is stored
	private int rear; // index at which rear element is stored
	private int size;
	
	
	public QueueUsingArray(){
		data = new int[10];
		front = -1;
		rear = -1;
		size=0;
	}
	
	public QueueUsingArray(int capacity){
		data = new int[capacity];
		front = -1;
		rear = -1;
		size=0;
	}
	
	int size(){
		return size; //O(1)
	}
	
	boolean isEmpty(){
		return size == 0;   //O(1)
	}
	
	int front() throws QueueEmptyException{
		if(size() == 0){
			throw new QueueEmptyException();
		}
		return data[front]; //O(1)
	}
	
	private void doubleCapacity(){
		int temp[] = data;
		data = new int[temp.length*2];
		
		int index=0;
		for(int i=front;i < temp.length; i++){
			data[index]=temp[i];
			index++;
		}
		
		for(int i=0;i< front;i++){
			data[index]=temp[i];
			index++;
		}
		front = 0;
		rear= temp.length-1;
		
	}
	
	void enqueue(int element) throws QueueFullException{
		if(size() == data.length){
			
			doubleCapacity();
			
		}
		if(size() == 0){
			front=0;
		}
		
		
		size++;
		rear = (rear + 1)% data.length;
//		rear++;
//		if(rear == data.length){
//			rear=0; //we made a circular queue
//		}
		data[rear] = element;
		
		 //O(1)
		
	}
	
	 int dequeue() throws QueueEmptyException{
		 if(front == -1){
			 throw new QueueEmptyException();
		 }
		 int temp = data[front];
		 front = (front + 1)% data.length;
//		 front++;
//		 if(front == data.length){
//			 front = 0;
//		 }
		 size--;
		 if(size == 0){
			 front = -1;
			 rear = -1;
		 }
		 return temp;
		 //O(1)
	 }
	
	
	
	
	
}
