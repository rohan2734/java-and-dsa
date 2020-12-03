package stacks_and_queues;

public class QueueLLUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws QueueEmptyException,QueueFullException{
		// TODO Auto-generated method stub
		QueueUsingLL queue = new QueueUsingLL();
		
		for(int i=0;i<5;i++){
			queue.enqueue(i);
		}
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
		
	}

}
