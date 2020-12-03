package stacks_and_queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class reverse_Queue {

	/**
	 * @param args
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static Queue<Integer> takeInput() throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine().trim());

		String[] values = br.readLine().trim().split(" ");

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(values[i]));
		}

		return queue;

	}
	public static void reverseQueue(Queue<Integer> input) {
	        
	        if(input.size()<=1){
	            return;
	        }
			//Your code goes here
	        int temp = input.remove();
	        
	        reverseQueue(input);
	        
	        input.add(temp);
	        
	        
	}
	public static void main(String[] args) throws IOException,QueueEmptyException{
		// TODO Auto-generated method stub
		
		int t = Integer.parseInt(br.readLine().trim());

		while (t > 0) {
			Queue<Integer> queue = takeInput();
			reverseQueue(queue);

			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}

			System.out.println();

			t -= 1;
		}
		
	}

}
