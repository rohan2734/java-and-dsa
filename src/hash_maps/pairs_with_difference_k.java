import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class pairs_with_difference_k {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

    public static int getPairsWithDifferenceK(int arr[], int k) {
        //Write your code here
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++){
			int key = arr[i];
			if(!map.containsKey(key)){
				map.put(key, 1);
			}else{
				int value = map.get(key);
				map.put(key, value+1);
			}
			
			
		}
		int count=0;
		
		for( int i=0;i<arr.length;i++){
			int key= arr[i];
			int value = map.get(key);
			if( value == 0){
				continue;
			}
			//else
			int greaterKey= key+k;
			int lesserKey = key-k;

			if(greaterKey == lesserKey && map.containsKey(greaterKey) && map.get(greaterKey) > 0 ){
				int greaterKeyValue = map.get(greaterKey);
				count+= (value*(greaterKeyValue-1))/2; 
				map.put(greaterKey, 0); 
			}

			if(map.containsKey(greaterKey) && map.get(greaterKey) > 0){
				int greaterKeyValue = map.get(greaterKey);
				count+= value*greaterKeyValue; 
				
				//map.put(greaterKey, 0);
			}

			if(map.containsKey(lesserKey) && map.get(lesserKey) > 0){
				int lesserKeyValue = map.get(lesserKey);
				count+= value*lesserKeyValue; 
				//map.put(lesserKey, 0);
			}

			map.put(key, 0);
		}
		return count;
		 
        
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		System.out.println(getPairsWithDifferenceK(arr, k));
	}
}
