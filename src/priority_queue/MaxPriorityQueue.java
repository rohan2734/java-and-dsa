package priority_queue;

import java.util.ArrayList;

public class MaxPriorityQueue {
    private ArrayList<Integer> heap;

    public MaxPriorityQueue(){
        heap = new ArrayList<>();
    }

    public boolean isEmpty(){
        return heap.size()==0;
    }
    public int getSize(){
        return heap.size();
    }

    public int getMax(){
        return heap.get(0);
    }

    void insert(int element){
        //maintain upward heapify
        heap.add(element);

        int childIndex= heap.size()-1;
        int parentIndex = (childIndex-1)/2;
        while(childIndex>0){
            if(heap.get(childIndex) > heap.get(parentIndex)){
                int temp= heap.get(parentIndex);
                heap.set(parentIndex , heap.get(childIndex));
                heap.set(childIndex, temp);

                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;
            }else{
                return;
            }
        }

        
    }


    int removeMax(){
		// Implement the removeMax() function here
       if(heap.isEmpty()){
           return Integer.MIN_VALUE;
       }
        
        int temp=heap.get(0);//root is max

        int index=0;
        int maxIndex =index;
        int leftChildIndex=1;
        int rightChildIndex=2;

        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        while(leftChildIndex < heap.size()){
            if(heap.get(leftChildIndex) > heap.get(maxIndex)){
                maxIndex = leftChildIndex;
            }
            if(rightChildIndex< heap.size() &&  heap.get(rightChildIndex) > heap.get(maxIndex)){
                maxIndex = rightChildIndex;
            }
            if(maxIndex == index){
                break;
            }else{
                int temp1=heap.get(index);
                heap.set(index,heap.get(maxIndex));
                heap.set(maxIndex, temp1);
        
                index=maxIndex;
                leftChildIndex = 2*index+1;
                rightChildIndex= 2* index+2;
            }
        }
        
       
        return temp;
	}
}
