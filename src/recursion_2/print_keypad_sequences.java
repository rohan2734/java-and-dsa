package recursion_2;

public class print_keypad_sequences {
	
	public static String[] helper(int n) {
		//String ans[];
		if(n==2) {
			String ans[]= {"a","b","c"};
			return ans;
		}else if(n==3) {
			String ans[] = {"d","e","f"};
			return ans;
		}else if(n==4) {
			String ans[] = {"g","h","i"};
			return ans;
		}else if(n==5) {
			String ans[]={"j","k","l"};
			return ans;
		}else if(n==6) {
			String ans[]= {"m","n","o"};
			return ans;
		}else if(n==7) {
			String ans[]= {"p","q","r","s"};
			return ans;
		}else if(n==8) {
			String ans[]= {"t","u","v"};
			return ans;
		}else if(n==9) {
			String ans[] = {"w","x","y","z"};
			return ans;
		}
		String ans[]= {""};
		return ans;
	}
	
	public static void printKeypad(int input,int num,String outputSoFar) {
		if(input == 0) {
			String ansHelpNum[] = helper(num); 
			for(int i=0;i<ansHelpNum.length;i++) {
				System.out.println(ansHelpNum[i] + outputSoFar);
			}
			return;
		}
		String ansHelpNum[] = helper(num);
		for(int i=0;i<ansHelpNum.length;i++) {
			printKeypad(input/10,input%10,ansHelpNum[i] + outputSoFar);
		}
		
		
	}
	public static void printKeypad(int input) {
		printKeypad(input/10,input%10,"");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input=234;
		printKeypad(input);
	}

}
