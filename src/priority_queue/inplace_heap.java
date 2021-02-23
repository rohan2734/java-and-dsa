package priority_queue;
//inplace heap, is a heap which doesnt require extra space
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class inplace_heap {

    public static void inplaceHeapSort(int arr[]) {
		//upward heapify , has minimum at the 0th index of the array
        for(int i=1;i<arr.length;i++){
            int childIndex = i;
            int parentIndex = (i-1)/2;

            while(childIndex > 0){
                if(arr[parentIndex]> arr[childIndex]){
                    int temp = arr[parentIndex];
                    arr[parentIndex] = arr[childIndex];
                    arr[childIndex] = temp;

                    childIndex = parentIndex;
                    parentIndex= (childIndex-1)/2;
                }else{
                    break;
                }
            }
        }

        //descending order
        for(int i=1;i<arr.length;i++){
            int removedNode = arr[0];
            //min element, needs to be shifted to last element
            int lastNode = arr[arr.length-i];
            arr[0] = lastNode;
            arr[arr.length-i] = removedNode;

            
            int leftChildIndex=1;
            int rightchildIndex=2;

            int index=0;
            int minIndex=index;
            while(leftChildIndex< arr.length-i ){
                if(arr[leftChildIndex] < arr[minIndex]){
                    minIndex = leftChildIndex;
                }
    
                if(rightchildIndex< arr.length-i && arr[rightchildIndex] < arr[minIndex]){
                    minIndex = rightchildIndex;
                }
                if(minIndex == index){
                    break;
                }else{
                    int temp=arr[index];
                    arr[index]=arr[minIndex];
                    arr[minIndex] = temp;
    
                    index= minIndex;
    
                    leftChildIndex= index*2+1;
                    rightchildIndex = index*2+2;
                }
            }
            

        }


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
		inplaceHeapSort(input);
		for (int i : input) {
			System.out.print(i + " ");
		}
	}
    
}
