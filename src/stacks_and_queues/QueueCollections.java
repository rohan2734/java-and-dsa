package stacks_and_queues;

import java.util.Queue;
import java.util.LinkedList;

public class QueueCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		System.out.println(queue.peek());
		System.out.println(queue.size());
		
	}

}
