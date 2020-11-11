package time_and_space_complexity_analysis;

public class check_rotation {
	
	public static int checkRotation(int input[]) {
		int i=0;
		while(i+1< input.length && input[i]< input[i+1]) {
			i++;
		}
		return i+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {5,6,1,2,3,4};
		
		int output = checkRotation(input);
		System.out.print(output);
	}

}
