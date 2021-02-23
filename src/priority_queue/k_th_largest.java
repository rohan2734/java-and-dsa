package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class k_th_largest {
    public static int kthLargest(int n, int[] input, int k) {
		// Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }

        for(int i=k;i<n;i++){
            if(input[i] > pq.peek() ){
                if(!pq.isEmpty()){
                    pq.poll();
                    pq.add(input[i]);
                }
            }
        }

        return pq.poll();

	}

    public static int kthLargest_lec(int n,int input[],int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            minHeap.add(input[i]);
        }

        for(int i=0;i<n;i++){
            if(input[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(input[i]);
            }
        }
        return minHeap.peek();
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
		System.out.println(kthLargest(n, input, k));
	}
}
