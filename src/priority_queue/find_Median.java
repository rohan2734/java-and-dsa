package priority_queue;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class find_Median {
    public static void findMedian(int arr[])  {
        
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            if(minHeap.isEmpty() && maxHeap.isEmpty()){
                minHeap.add(arr[i]);
                System.out.print(arr[i] +" ");
            }else if(maxHeap.isEmpty()){
                maxHeap.add(arr[i]);
                int median = (maxHeap.peek() + minHeap.peek())/2;
                System.out.print(median +" ");
            }else if(arr[i] < minHeap.peek()){
                maxHeap.add(arr[i]);
                
                if( maxHeap.size() - minHeap.size() >1  ){
                    int element = maxHeap.poll();
                    minHeap.add(element);
                }else if(minHeap.size() - maxHeap.size() > 1){
                    int element = minHeap.poll();
                    maxHeap.add(element);
                }

                if((i+1)%2 == 0){
                    int median = (minHeap.peek() + maxHeap.peek())/2;
                    System.out.print(median +" ");
                }else{
                    if(maxHeap.size() > minHeap.size()){
                        int median = maxHeap.peek();
                        System.out.print(median +" ");
                    }else{
                        int median = minHeap.peek();
                        System.out.print(median +" ");
                    }
                }
            }else if(arr[i] > minHeap.peek()){
                minHeap.add(arr[i]);

                if( maxHeap.size() - minHeap.size() >1  ){
                    int element = maxHeap.poll();
                    minHeap.add(element);
                }else if(minHeap.size() - maxHeap.size() > 1){
                    int element = minHeap.poll();
                    maxHeap.add(element);
                }

                if((i+1)%2 == 0){
                    int median = (minHeap.peek() + maxHeap.peek())/2;
                    System.out.print(median +" ");
                }else{
                    if(maxHeap.size() > minHeap.size()){
                        int median = maxHeap.peek();
                        System.out.print(median +" ");
                    }else{
                        int median = minHeap.peek();
                        System.out.print(median +" ");
                    }
                }
                
            }
        }

    
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        findMedian(arr);


    }
}
