package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class buy_the_ticket {
    public static int buyTicket(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/

        int totalTime=0;

        Queue<Integer> queue = new LinkedList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<input.length;i++){
            queue.add(i);
            maxHeap.add(input[i]);
        }
        boolean isRemoved = false;
        while(!isRemoved){
            int topElement = queue.peek();//returns top element (indexes)
            
            int topPriorityElement = maxHeap.peek();
            
            if(input[topElement] == topPriorityElement){

                queue.poll();
                maxHeap.poll();

                if(k == topElement){
                    isRemoved = true;
                    totalTime+=1;
                    return totalTime;
                }

                totalTime+=1;

            }else{

                queue.add(queue.poll());

            }
        }

        return totalTime;

	}

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(buyTicket(input, k));
	}
}


