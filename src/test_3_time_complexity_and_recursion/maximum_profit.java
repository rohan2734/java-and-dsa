package test_3_time_complexity_and_recursion;
import java.util.*;

public class maximum_profit {
	
//	public static int maximumProfit(int budget[]) {
//		int totalNumberOfBuyers[]=new int[budget.length];
//		int profit[] = new int[budget.length];
//		
//		for(int i=0;i<budget.length;i++) {
//			for(int j=0;j<budget.length;j++) {
//				if(budget[j] >= budget[i]) {
//					totalNumberOfBuyers[i] += 1;
//				}
//			}
//		}
//		int max=0;
//		int maxBuyer=0;
//		for(int i=0;i<profit.length;i++) {
//			profit[i] = totalNumberOfBuyers[i]*budget[i];
//			if(max < profit[i]) {
//				maxBuyer=i;
//				max = profit[i];
//			}
//		}
//		return max;
//		
//	}
	
	public static int maximumProfit(int budget[]) {
		int m[] = new int[budget.length];
		int profit[] = new int[budget.length];
		
		Arrays.sort(budget);
		int max=0;
		for(int i=0;i<=budget.length-1;i++) {
			profit[i] = budget[i] * (budget.length-i);
			if(max<profit[i]) {
				max=profit[i];
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int budget[] = {30,20,53,14};
		int output = maximumProfit(budget);
		System.out.print(output);
	}

}
