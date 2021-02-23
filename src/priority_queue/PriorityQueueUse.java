package priority_queue;

public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
        priority_queue pq= new priority_queue();
        int arr[] = {5,1,9,2,0};
        for(int i=0;i<arr.length;i++){
           pq.insert(arr[i]); 
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.removeMin()+"");
        }
        System.out.println();
    }
}
