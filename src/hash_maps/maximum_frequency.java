import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class maximum_frequency {
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
    public static int maxFrequencyNumber(int[] arr){ 
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        HashMap<Integer,Integer> map = new HashMap<>();

        if(arr.length == 0){
            return -1;
        }
        int maxKey =arr[0];
        for(int i=0;i<arr.length;i++){
            int key = arr[i];
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                int value = map.get(key);
                value+=1;
                map.put(key,value);
                if(map.get(key) > map.get(maxKey)){
                    maxKey = key;
                }
            }
        }

        return maxKey;
        // int maxkey=arr[0];
        // Set<Integer> numkeys =map.keySet(); 
        // for (Integer numkey: numkeys){
        //     if(map.get(numkey) > map.get(maxkey)){
        //         maxkey=numkey;
        //     }
        // }

        // return maxkey;
    }  
    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.println(maxFrequencyNumber(arr));


    }
}
