package recursion_2;

public class return_keypad_code {
	
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
    public static String[] returnKeypad(int input,int num) {
		if(num == 0 ||  num == 1) {
			String ans[] = {""};
			return ans;
		}
		String smallAns[] = returnKeypad(input/10,input%10);
        String ansHelp[] = helper(num);
		String ans[] = new String[smallAns.length * ansHelp.length];
		
		int k=0;
		for(int i=0;i<smallAns.length;i++) {
			for(int j=0;j<ansHelp.length;j++) {
				ans[k]=smallAns[i] + ansHelp[j];
				k++;
			}
		}
		return ans;
	}

	public static String[] returnKeypad(int input) {
		return returnKeypad(input/10,input%10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int input=23;
		 String ans[]= returnKeypad(input);
		 for(int i=0;i<ans.length;i++) {
			 System.out.println(ans[i]);
		 }
	}

}
