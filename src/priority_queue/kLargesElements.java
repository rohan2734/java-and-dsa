
package priority_queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargesElements {

    public static ArrayList<Integer> kLargest(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<input.length;i++){
            pq.add(input[i]);
        }
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<k;i++){
            arrayList.add(pq.remove());
        }
        int i=0;
        int j=arrayList.size()-1;
        while(i<j){
            int temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(j));
            arrayList.set(j, temp);
            i++;
            j--;
        }
        return arrayList;
		
	}

    public static ArrayList<Integer> KLargestLec (int input[],int k){
        PriorityQueue<Integer> pq  = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }

        for(int i=k;i<input.length;i++){
            if(input[i]>pq.peek()){
                pq.poll();
                pq.add(input[i]);
            }
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        while(!pq.isEmpty()){
            output.add(pq.poll());
        }
        return output;
    }
    static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}
}
