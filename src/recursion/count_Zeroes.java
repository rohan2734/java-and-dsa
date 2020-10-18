package recursion;

public class count_Zeroes {
	public static int countZeroes(int num,int count) {
		if(num/10 == 0) {
			if(num==0) {
				count+=1;
			}
				return count;
		}
		if(num%10 == 0) {
			count+=1;
		}
		return countZeroes(num/10,count);
		
		
	}
	
	public static int countZeroes(int num) {
		return countZeroes(num,0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=10204;
		int ans=countZeroes(num);
		System.out.print(ans);
	}

}
