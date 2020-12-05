package test_2__LL_stacks_n_queues;

public class double_ended_queue {

	/**
	 * @param args
	 */
	
	public static class Dequeue {
		private int front;
		private int rear;
		private int size;
		private int data[];
		
		Dequeue(int capacity){
			data = new int[capacity];
		}
		
		int getSize(){
			return size;
		}
		
		void insertFront(int element){
			if(getSize() == data.length){
				System.out.println("-1");
				return;
			}
			if(getSize() == 0){
				data[front] = element;
				front++;
				return;
			}
			int temp[] = data;
			
			data = new int[data.length+1];
			for(int i=0;i<=front;i++){
				data[i]=temp[i];
			}
			data[front+1] = element;
			for(int i=front+1;i<data.length;i++){
				data[i+1]=temp[i];
			}
			return;
			size++;
			
		}
		
		void insertRear(int element){
			if(getSize() == data.length){
				System.out.println("-1");
				return;
			}
			if(getSize() == 0){
				data[rear] = element;
				rear++;
				return;
			}
			int temp[]=data;
			data = new int[data.length+1];
			
			for(int i=0;i<=rear;i++){
				data[i]=temp[i];
			}
			data[rear+1] = element;
			for(int i=rear+1;i<data.length;i++){
				data[i+1]=temp[i];
			}
			size++;
			return;
		}
		
		boolean isEmpty(){
			return size == 0;
		}
		
		void deleteFront(){
			if(isEmpty()){
				System.out.println("-1");
				return;
			}
			int temp=data[front];
			size--;
			front = (front+1)%data.length;
			if(size == 0){
				front = 0;
				rear = 0;
			}
			
			System.out.println(temp);
			return;
			
		}
		void deleteRear(){
			if(isEmpty()){
				System.out.println("-1");
				return;
			}
			int temp=data[rear];
			size--;
			rear = (rear+1)%data.length;
			if(size == 0){
				front = 0;
				rear = 0;
			}
			
			System.out.println(temp);
			return;
			
		}
		void getFront(){
			if(isEmpty()){
				System.out.println("-1");
				return;
			}
			 System.out.println(data[front]);
			 return;
		}
		void getRear(){
			if(isEmpty()){
				System.out.println("-1");
				return;
			}
			 System.out.println(data[rear]);
			 return;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
