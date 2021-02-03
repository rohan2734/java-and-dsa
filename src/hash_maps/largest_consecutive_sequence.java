import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class largest_consecutive_sequence {


    // public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		
        
    //     HashMap<Integer,Integer> map = new HashMap<>();
        
    //     Arrays.sort(arr);

    //     // System.out.printf("Modified arr[] : %s",
    //     // Arrays.toString(arr));

    //     int prev = arr[0]-1;
    //     int i=0;
    //     int key= arr[0];
    //     while(i< arr.length){
         
    //         if(arr[i]-1 == prev){
                
    //             if(!map.containsKey(key)){
    //                 map.put(key,1);
    //             }else{
    //                 int value = map.get(key);
    //                 map.put(key, value+1);
    //             }
               
    //         }else{
    //             key=arr[i];
    //             map.put(key, 1);
    //         }
    //         prev=arr[i];
    //         i++;
    //     }

    //     int maxLength = map.get(arr[0]);
    //     int maxKey= arr[0];
    //     for(int j=0;j<arr.length;j++){
    //         int tempKey = arr[j];
    //         int value =0;
    //         if(map.containsKey(tempKey)){
    //             value = map.get(tempKey);
    //         }
           

    //         if(maxLength < value){
    //             maxLength = value;
    //             maxKey= arr[j];
    //         }
    //     }

    //     ArrayList<Integer> output = new ArrayList<>();

    //     if(maxLength == 1){
    //         output.add(maxKey);
    //     }else{
    //         output.add(maxKey);
    //         output.add(maxKey + maxLength-1);
    //     }

    //     return output;
           
            
    // }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        HashMap<Integer,Integer> mapIndices = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            map.put(key, true);
            mapIndices.put(key,i);
        }
        int maxKey=arr[0];
        int maxLength=1;
        for(int i=0;i<arr.length;i++){
            
            int key = arr[i];
            if(map.get(key) == false){
                continue;
            }
            int nextKey=key+1;
            int prevKey = key-1;
            int tempSize=1;
            while( map.containsKey(nextKey)){
                map.put(nextKey, false);
                tempSize++;
                nextKey++;
            }
            while(map.containsKey(prevKey)){
                map.put(prevKey, false);
                tempSize++;
                prevKey--;
            }

            if(maxLength < tempSize){
                maxLength=tempSize;
                maxKey=prevKey+1;
            }else if(maxLength == tempSize){
                if(mapIndices.containsKey(prevKey+1) && mapIndices.get(prevKey+1) < mapIndices.get(maxKey)){
                    maxLength=tempSize;
                    maxKey=prevKey+1;
                }
            }
            
        }

        ArrayList<Integer> output = new ArrayList<>();
        output.add(maxKey);
        if(maxLength>1){
            output.add(maxKey+maxLength-1);   
        }

        return output;
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

    public static void printArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        ArrayList<Integer> ans = longestConsecutiveIncreasingSequence(arr);
        printArray(ans);

    }
}
