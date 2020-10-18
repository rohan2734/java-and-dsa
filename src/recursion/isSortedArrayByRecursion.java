package recursion;

public class isSortedArrayByRecursion {
	
	public static boolean isSorted(int n,int arr[]) {
		if(arr[0]>arr[1]) {
			return false;
		}else if(n-2>=0 && n-1>=0 && arr[n-1]<arr[n-2]) {
			return false;
		}else if(n<0){
			return true;
		}
		boolean isValid=true;
		return isValid && isSorted(n-1,arr);
	}
	
	//this funciton now checks if the array is sorted from startIndex to end
	private static boolean checkSortedBetter(int input[],int startIndex) {
		if(startIndex >= input.length -1) {
			return true;
		}
		if(input[startIndex] > input[startIndex+1]) {
			return false;
		}
		boolean smallAns= checkSortedBetter(input,startIndex+1);
		return smallAns;
	}
	
	public static boolean checkSortedBetter(int input[]) {
		return checkSortedBetter(input,0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int arr[]= {1,3,6,7};
//		boolean result=isSorted(arr.length,arr);
//		System.out.print(result);
		
		int input[]= {1,2,3};
		System.out.println(checkSortedBetter(input));
	}

}
