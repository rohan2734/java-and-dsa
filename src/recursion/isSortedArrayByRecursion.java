package recursion;

public class isSortedArrayByRecursion {
	
	public static boolean isSorted(int n,int arr[]) {
		if(arr[0] < arr[1]) {
			return false;
		}
		boolean isValid=true;
		return isValid && (arr[n-1] < arr[n-2] ? false : true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
