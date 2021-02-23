package priority_queue;

import java.util.PriorityQueue;

public class kSortedArray {
    
    public static void kSortedArrayFunction(int arr[],int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for(i=0;i<k;i++){
            pq.add(arr[i]);
        }
        //added first  k elements
       //i is not initialized, i value is taken from above
        for(;i<arr.length;i++){
            arr[i-k]=pq.remove();
            pq.add(arr[i]);
        }
        //in the end, just remove the remaining elements of the heap
        for(int j=arr.length-k;j<arr.length;j++){
            arr[j] = pq.remove();
        }
        
    }
    public static void main(String[] args) {
        int arr[] = {2,4,1,9,6,8};
        int k=3;
        kSortedArrayFunction(arr,k);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
}
