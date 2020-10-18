package recursion;

public class firstIndexOfNumber {
	/**
	 * no need to add isMatch it will work without it also
	 * @param args
	 */
	public static int firstIndex(int input[],int x,int startIndex) {
		if(startIndex >= input.length-1 ) {
			return -1;
		}
		
		if(input[startIndex] == x ) {
			return startIndex;
		}
		
		int smallAns = firstIndex(input,x,startIndex+1);
		return smallAns;
		
	}

	public static int firstIndex(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        return firstIndex(input,x,0);
		
	}
	
//	public static int firstIndex(int input[],int x,int startIndex,boolean isMatch) {
//		if(startIndex >= input.length-1 && !isMatch) {
//			return -1;
//		}
//		
//		if(input[startIndex] == x && !isMatch) {
//			isMatch=true;
//			return startIndex;
//		}
//		
//		int smallAns = firstIndex(input,x,startIndex+1,isMatch);
//		return smallAns;
//		
//	}
//	
//	public static int firstIndex(int input[], int x) {
//		return firstIndex(input,x,0,false);
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3};
		int ans=firstIndex(arr,2);
		System.out.print(ans);
	}

}
