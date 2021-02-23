package priority_queue;

import java.util.*;

public class priority_queue{

    private ArrayList<Integer> heap;

    public priority_queue(){
        heap = new ArrayList<>();
    }

    public boolean isEmpty(){
        return heap.size()==0;
    }

    public int size(){
        return heap.size();
    }

    public int getMin() throws PriorityQueueException{
        if(isEmpty()){
            //Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element){
        heap.add(element);
        //apply upward heapify
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0){
            if(heap.get(childIndex) < heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);

                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else{
                return;
            }
        }
        
    }

    // int removeMin() throws PriorityQueueException{

    //     if(isEmpty()){
    //         throw new PriorityQueueException();
    //     }
    //     int removedNode=heap.get(0);
    //     int lastNode = heap.get(heap.size()-1);
    //     heap.set(0,lastNode);
    //     heap.remove(0);

    //     int parentIndex=0;
    //     int leftChildIndex = 1;
    //     int rightChildIndex=2;
    //     while(parentIndex < heap.size()){
    //         if(heap.get(parentIndex) > heap.get(leftChildIndex)){
    //             int temp = heap.get(parentIndex);
    //             heap.set(parentIndex,heap.get(leftChildIndex));
    //             heap.set(leftChildIndex,temp);

    //             int tempIndex= leftChildIndex;
    //             leftChildIndex = parentIndex;
    //             parentIndex = tempIndex;
    //         }

    //         if(heap.get(parentIndex) > heap.get(rightChildIndex)){
    //             int temp = heap.get(parentIndex);
    //             heap.set(parentIndex,heap.get(rightChildIndex));
    //             heap.set(rightChildIndex,temp);

    //             int tempIndex= rightChildIndex;
    //             rightChildIndex = parentIndex;
    //             parentIndex = tempIndex;
    //         }
    //         else{
    //             return removedNode;
    //         }
    //     }

    //     return removedNode;

    // }
    int removeMin() throws PriorityQueueException{
        
        if(isEmpty()){
            //Throw an exception
            throw new PriorityQueueException();
        }
        int temp = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //downward heapify
        //take minimum of left and right
        //replace with the minimum of left and right
        int index=0;
        int minIndex = index;
        int leftChildIndex=1;
        int rightChildIndex=2;

        while(leftChildIndex < heap.size()){
            if(heap.get(leftChildIndex) < heap.get(minIndex)){
                minIndex=leftChildIndex;   
            }
            
            if(rightChildIndex<heap.size()&& heap.get(rightChildIndex) < heap.get(minIndex)){
                minIndex=rightChildIndex;   
            }
    
            if(minIndex == index){
                break;
            }else{
                int temp1 = heap.get(index);
                heap.set(index,heap.get(minIndex));
                heap.set(minIndex,temp1);
                index=minIndex;
                leftChildIndex = 2*index+1;
                rightChildIndex=2*index+2;
            }
        }
        return temp;
    }
}