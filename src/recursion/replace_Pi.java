package recursion;

public class replace_Pi {

	public static String Replace_pi(String input,int startIndex,String storeOutput){
		if(startIndex >= input.length()) {
			 return storeOutput;
		}
		if(input.charAt(startIndex) == 'p' && startIndex+1 < input.length() && input.charAt(startIndex+1) == 'i') {
			storeOutput+="3.14";
			startIndex+=1;
		}else{
			storeOutput+= input.charAt(startIndex);
			//System.out.println(storeOutput);
		}
		
		return Replace_pi(input,startIndex+1,storeOutput);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="xpix";
		input="pipi";
		input="pippiippip";
		String output=Replace_pi(input,0,"");
		System.out.print(output.substring(0));
	}

}
