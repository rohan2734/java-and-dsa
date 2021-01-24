import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class print_intersection {
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

    public static void intersection(int[] arr1, int[] arr2) {
        //Your code goes here
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0,j=0;

        ArrayList<Integer> arrayList = new ArrayList<>();

        while(i< arr1.length ){
            if(map.containsKey(arr1[i])){
                int value = map.get(arr1[i]);
                value+=1;
                map.put(arr1[i],value);
            }else{
                map.put(arr1[i],1);
            }
            i++;
        }

        while( j < arr2.length){
            if(map.containsKey(arr2[j]) && map.get(arr2[j]) > 0){
                // System.out.print(arr2[j] +" ");
                arrayList.add(arr2[j]);
                int value = map.get(arr2[j]);
                value-=1;
                map.put(arr2[j],value);
            }
            j++;
        }
        Collections.sort(arrayList);
        // System.out.println();

        for(int k=0;k<arrayList.size();k++){
            System.out.print(arrayList.get(k) +" ");
        }


    }
    
    public static void intersection2(int arr1[],int arr2[]){
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;
        int m = arr2.length;

        int i=0;
        int j=0;

        while(i < n && j < m){
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] +" ");
                i++;j++;
            }else if(arr1[i] > arr2[j]){
                j++;
            }else{
                i++;
            }
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr1 = takeInput();
            int[] arr2 = takeInput();
            intersection(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }
}


