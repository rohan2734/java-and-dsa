package strings;

public class lecturers_check_permutation {
	
	public static boolean checkPermutation(String input1,String) {
		int freq[]= new int[256];
		for(int i=0;i<input1.length();i++) {
			int index=input1.charAt(i);
			freq[index]++;
		}
		for(int i=0;i<input2.length();i++) {
			int index=input2.charAt(i);
			freq[index]--;
		}
		for(int i:freq) {
			if(i!=0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
