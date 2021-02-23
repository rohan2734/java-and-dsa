import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
// import java.util.Arrays;
import java.util.StringTokenizer;

public class longest_subset_zero_sum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();

        int tempSum=0;
        int maxLength = 0;
        
        for(int i=0;i<arr.length;i++){
        
            tempSum+=arr[i];
            int key = tempSum;
            if(tempSum == 0){
                int tempSize = i+1;
                if(tempSize > maxLength){
                    maxLength = tempSize;
               }
              
                continue;
            }
            if(map.containsKey(key)){
               int tempSize = i - map.get(key); 
               if(tempSize > maxLength){
                    maxLength = tempSize;
               }
              
                continue;
            }
            map.put(key,i);
        }

        return maxLength;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
	}
}
