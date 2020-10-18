package recursion;

public class checkNumberInArray {
	
	public static boolean checkNumber(int input[],int x) {
		if(input.length <= 1 && input[0]!=x) {
			return false;
		}
		if(input[0] == x) {
			return true;
		}else {
			int subInput[]=new int[input.length-1];
			for(int i=1;i<input.length;i++) {
				subInput[i-1]=input[i];
			}
			return checkNumber(subInput,x);
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {1,2,3,4,5};
		boolean result=checkNumber(input,5);
		System.out.print(result);
	}

}
