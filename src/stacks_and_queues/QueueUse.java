package stacks_and_queues;

public class QueueUse {

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		QueueUsingArray queue = new QueueUsingArray();
		for(int i=1;i<=5;i++){
			try{
				queue.enqueue(i);
			}catch(QueueFullException e){
				e.printStackTrace();
			}
			
		}
		
		while(!queue.isEmpty()){
			try{
				System.out.println(queue.dequeue());
			}catch(QueueEmptyException e){
				e.printStackTrace();
			}
		}
	}

}
