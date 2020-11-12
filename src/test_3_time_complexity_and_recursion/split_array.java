package test_3_time_complexity_and_recursion;

public class split_array {
	
	public static boolean check(int input[],int startIndex, int lSum, int rSum) {
		if(startIndex == input.length) {
			return lSum == rSum;
		}
		if(input[startIndex] %5 == 0) {
			lSum+=input[startIndex];
		}else if(input[startIndex]%3==0) {
			rSum+=input[startIndex];
		}else {
			boolean lSumBoolean = check(input,startIndex+1,lSum+input[startIndex],rSum);
			boolean rSumBoolean = check(input,startIndex+1,lSum,rSum);
			
			return lSumBoolean || rSumBoolean;
		}
		
		
		return check(input,startIndex+1,lSum,rSum);
	}
	
	public static boolean splitArray(int input[]) {
		return check(input,0,0,0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {1,2,3,4,5};
		boolean output =   splitArray(input);
		System.out.print(output);
	}

}
