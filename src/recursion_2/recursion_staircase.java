package recursion_2;

public class recursion_staircase {
	
	public static int staircase(int n,int input) {
		if(n==0 || n==1) {
			return n;
		}
		if(input == n) {
			return 1;
		}
		if(input >n) {
			return 0;
		}
		int output1=staircase(n,input+1);
		int output2=staircase(n,input+2);
		int output3=staircase(n,input+3);
		//System.out.println("n: " + n + " input: " + input +   " output1: " + output1 + " output2: " + output2 + " output3: " + output3);
		return output1+output2+output3;
	}
	
	public static int lecturers_staircase(int n) {
		if(n<0) {
			return 0;
		}
		if(n==0)
			return 1;
		return lecturers_staircase(n-1) + lecturers_staircase(n-2) + lecturers_staircase(n-3);
	}
	
	public static int staircase(int n) {
		return staircase(n,0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int output = staircase(n);
		System.out.print(output);
	}

}
