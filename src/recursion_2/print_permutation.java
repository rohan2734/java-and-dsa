package recursion_2;
import java.util.*;

public class print_permutation {
	
	private static ArrayList<String> ans = new ArrayList<String>();
	
	public static ArrayList<String> FindPermutations(String input){
		char[] arr = input.toCharArray();
        helper(arr, 0, arr.length-1);
        return ans;
		
	}
	 private static void helper(char[] arr, int i, int j){
	        if(i>=j){
	            //print new permutation
	            String permutation = "";
	            for(int k=0;k<arr.length;k++){
	                permutation+=arr[k];
	            }
	            //for printing in next line
	            ans.add(permutation);
	            return;
	        }
	        for(int k=i;k<=j;k++){
	            swap(arr, i, k);
	            helper(arr, i+1, j);
	            swap(arr, i, k);
	        }
	    }
		private static void swap(char a[], int i, int j){
	        char t = a[i];
	        a[i] = a[j];
	        a[j] = t;
	    }

	public static void main(String[] args) {
		String input="abc";
		ArrayList<String> output=FindPermutations(input);
		for(int i = 0 ;i< output.size();i++) {
			//System.out.println(output[i].substring(0));
			System.out.println(output.get(i));
		}
		
	}

}
