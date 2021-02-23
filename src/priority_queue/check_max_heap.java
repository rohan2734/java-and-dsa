package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class check_max_heap {
    public static boolean checkMaxHeap(int arr[]) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
        for(int i=0;i<arr.length;i++){
            int parentIndex = i;
            int leftChildIndex = 2*parentIndex+1;
            int rightChildIndex = 2*parentIndex+2;

            
            if(leftChildIndex < arr.length && arr[leftChildIndex] > arr[parentIndex] || rightChildIndex < arr.length && arr[rightChildIndex] > arr[parentIndex]){
                return false;
            }
        }
        return true;
	}

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(checkMaxHeap(input));
	}
}

