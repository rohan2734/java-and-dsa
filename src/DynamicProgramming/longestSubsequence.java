import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class longestSubsequence {
    public static int lisHelper(int arr[],int i,int number){
        if(i>=arr.length){
            return 0;
        }
        int op1=0;
        int op2=0;
        if(number < arr[i]){
            op1=  1 + lisHelper(arr, i+1, arr[i]);
            op2 = lisHelper(arr, i+1, number);
            return Math.max(op1,op2);
        }
        return lisHelper(arr, i+1, number);
    }
    public static int lis(int arr[]) {
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        return lisHelper(arr, 0, 0);
		
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

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.println(lis(arr));



    }
}
