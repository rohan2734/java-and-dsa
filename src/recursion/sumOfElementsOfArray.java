package recursion;

public class sumOfElementsOfArray {
	
	public static int sum(int input[]) {
		if(input.length<=1) {
			return input[0];
		}
		int num=input[0];
		int subInput[]= new int[input.length-1];
		for(int i=1;i<input.length;i++) {
			subInput[i-1]=input[i];
		}
		return num+sum(subInput);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3};
		System.out.print(sum(arr));
	}

}
