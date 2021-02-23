package priority_queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinPQComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1,Integer o2){
        if(o1 < o2){
            return -1;
        }else if(o1>o2){
            return 1;
        }
        return 0;
    }
}

class MaxPQComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1,Integer o2){
        if(o1 > o2){
            return -1;
        }else if(o1 < o2){
            return 1;
        }
        return 0;
    }
}


// if(arr[childIndex] < arr[parentIndex]){//compare (o1,o2) <0
    //when the result is negative, then it gets swapped
    // int temp = arr[childIndex];
    // arr[childIndex] = arr[parentIndex];
    // arr[parentIndex ] = temp;
// }

class StringLengthComparator implements Comparator<String>{
    @Override
    public int compare(String o1,String o2){
        if(o1.length() < o2.length()){
            return -1;
        }else if(o1.length() > o2.length()){
            return 1;
        }else{
            return 0;
        }
    }
}

public class Inbuilt_Max_and_Min_PriorityQueue_with_comparator {
    public static void main(String[] args) {

        String arr[] = {"this","at","a","their","queues"};
        StringLengthComparator stringLengthComparator = new StringLengthComparator();
        PriorityQueue<String> pq = new PriorityQueue<>(stringLengthComparator);

        // MinPQComparator minPQComparator = new MinPQComparator();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(minPQComparator);

        // MaxPQComparator maxPQComparator = new MaxPQComparator();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(maxPQComparator);

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //inbuilt maxPQComparator
        
    }
}
