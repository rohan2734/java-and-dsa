package priority_queue;

import java.util.PriorityQueue;

public class Inbuilt_MinPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int arr[] = {9,1,0,4,7,3};

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            //insert => add
            //getMin() => peek #peek doesnt throw exception
            //getMin() => element #element throws exception
            //returns minimum element
            //remove() => remove
        }

        // System.out.println(pq.element()); 
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }


    }
}
