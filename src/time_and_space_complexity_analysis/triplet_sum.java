package time_and_space_complexity_analysis;
import java.util.*;

public class triplet_sum {
	
	public static int tripletSum(int input[],int num) {
		
		int countOfTriplets = 0; 
		Arrays.sort(input); //nlogn time complexity
		
		for(int i=0;i<input.length-1;i++) {
			int j=i+1;
			int k= input.length-1;
			
			while( j < k) {
				int sum = input[i]+input[j] + input[k];
				if(sum<num) {
					j++;
				}else if(sum>num) {
					k--;
				}else {
					//sum = num
					
					if(input[j] == input[k]) {
						int len=k-j+1;
						countOfTriplets += (len* (len-1))/2;
						break;
					}
					
					int start = j+1;
					int end = k -1;
					
					while(start<=end && input[j] == input[start]) {
						start++;
					}
					while(end>=start && input[k] == input[end]  ) {
						k--;
					}
					
					int f1= start-j;
					int f2= k-end;
					
					countOfTriplets+= f1*f2;
					
					j=start;
					k=end;
					
					//end
				}
				
			}
			
			
		}
		return countOfTriplets;
		
	}

//	public static int lecturers_tripletSum(int input[],int num) {
//		
//		int count=0, n = arr.length;
//        Arrays.sort(arr);
//		for(int i=0; i<n-1; i++)
//		{
//            int j = i + 1;
//            int k = n-1;
//            while(j<k){
//                
//                
//         if(arr[i]+arr[j]+arr[k] < num)
//                    j++;
//             else if(arr[i]+arr[j]+arr[k] > num)
//                    k--;
//         else
//         {
//             
//             if(arr[j]==arr[k]){
//                 
//              int m=k-j+1;   
//                 count+= (m*(m-1))/2; 
//                 break;
//             }
//             
//          int start=j+1;  
//          int  end=k-1;
//            
//        while(start<=end && arr[j]==arr[start])
//             start++;
//             
//          while(end>=start &&arr[k]==arr[end])
//              end--;
//             
//            int f1= start-j;
//             int f2=k-end;
//             count+=f1*f2;
//             
//             j=start;
//             k=end;
//             
//         }
//               
//            }
//			
//		}
//		return count;
//		
//		
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {1,2,3,4,5,6,7};
		int num=12;
		int output= tripletSum(input,num);
		System.out.print(output);
	}	

}
