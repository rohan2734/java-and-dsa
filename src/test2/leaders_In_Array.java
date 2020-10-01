package test2;

public class leaders_In_Array {
	public static void leaders(int[] input) {
		int i=0,j=0;
		//boolean leaderFound=false;
		while(i<input.length && j<=input.length) {
			if(i==j) {
				j++;
			}else if(j<input.length && input[i]<input[j]) {
//				if(leaderFound) {
//					System.out.print(input[i]+" ");
//				}
				i=j;
			}else {
				if(j!=input.length-1 && j<input.length && input[j]<=input[j-1]) {
					System.out.print("j: "+j);
					j++;
				}
				else if(j==input.length-1 && input[j]<=input[j-1]) {
					
					int k=i;
					while(k<input.length) {
						System.out.print(input[k] +" ");
					}
					i=j;
					j++;
				}
				else {
					System.out.print(input[i] +" ");
					i=j;
				}
			}
		}
//		if(input[input.length -1]>input[input.length -2]) {
//			System.out.print(input[input.length-1]);
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int input[] = {3,12,34,2,0,-1,1};
		int input[]= {3,12,34,2,0,-1};
		leaders(input);
		
	}

}
