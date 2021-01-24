import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class pair_sum_to_zero {
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
    public static int PairSum(int[] input, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0;i<input.length;i++){
            arrayList.add(input[i]);    
        }

        Collections.sort(arrayList);

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arrayList.size();i++){
            int element = arrayList.get(i);
            if(!map.containsKey(element )){
                map.put(arrayList.get(i),1);
            }else{
                int value = map.get(element);
                value+=1;
                map.put(element,value);
            }
        }
        int i=0,j=arrayList.size()-1;
        int count=0;
        while(i<j){
            int elem1=arrayList.get(i);
            int elem2=arrayList.get(j);
            if(elem1 + elem2 == 0 && map.get(elem1)>0 && map.get(elem2) >0){
                if(elem1 == 0 && elem2 == 0){
                    count+=(map.get(elem1) *(map.get(elem1)-1))/2;
                    
                }else{
                    count+= map.get(elem1)*map.get(elem2);
                }
               
                map.put(elem1,0);
                map.put(elem2,0);
                i++;
                j--;
            }else if(elem1 + elem2 > 0){
                j--;
            }else{
                i++;
            }
        }

        return count;


        
    }
    
    public static int PairSum2(int[] input,int size){
        HashMap<Integer,Integer> map = new HashMap<>();
        int finalCount = 0;
        for (int i=0;i<size;i++){
            int key=input[i];
            if(map.containsKey(key)){
                int value = map.get(key);
                map.put(key, value+1);
            }else{
                map.put(key,1);
            }
        }

        for(int i=0;i<size;i++){
            int key=input[i];

            if(map.containsKey(-key) && map.get(key)!=0){
                int times;

                if(key == (-key)){
                    int occurences = map.get(key);
                    times = (occurences*(occurences-1))/2;
                    finalCount+=times;
                    map.put(key,0);
                    continue;
                }

                times = map.get(key)*map.get(-key);
                finalCount +=times;
                map.put(key, 0);
                map.put(-key, 0);
            }
        }

        return finalCount;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.print(PairSum(arr,arr.length));


    }
}
