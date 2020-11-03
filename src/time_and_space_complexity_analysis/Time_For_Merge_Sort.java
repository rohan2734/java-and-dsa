package time_and_space_complexity_analysis;

public class Time_For_Merge_Sort {
	public static void merge(int input[],int si,int ei) {
		int mid=(si + ei)/2;
		int s1=si;
		int e1=mid;
		int s2=mid+1;
		int e2=ei;
		int temp[]=new int[ei-si+1];
		int mi=0;
		
		while(s1<=e1 && s2<=e2) {
			if(input[s1] <= input[s2]) {
				temp[mi] = input[s1];
				mi+=1;
				s1++;
			}
			else if(input[s2]<input[s1]) {
				temp[mi] = input[s2];
				mi+=1;
				s2++;
			}
		}
		while(s1<=e1) {
			temp[mi] = input[s1];
			mi+=1;
			s1+=1;
		}
		while(s2<=e2) {
			temp[mi]= input[s2];
			mi+=1;
			s2+=1;
		}
		// System.out.println("temp array ...");
		// for(int i=0;i<temp.length;i++) {
		// 	System.out.print(temp[i] +" ");
		// }
		// System.out.println();
		
        for(int i=0;i<temp.length;i++){
            input[i+si]=temp[i];
        }
		return;
	}
	
	public static void mergeSort(int input[],int si,int ei) {
		if(si>=ei) {
			return;
		}
		int mid = (si+ei)/2;
		mergeSort(input,si,mid);
		mergeSort(input,mid+1,ei);
		merge(input,si,ei);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int n=10; n<= 10000000; n=n*10) {
			int[] input = new int[n];
			for(int i=0;i<input.length;i++) {
				input[i] = input.length-i;
			}
			
			long startTime = System.currentTimeMillis();
			mergeSort(input,0,input.length-1);
			long endTime = System.currentTimeMillis();
			System.out.println("Time by mergeSort for " + n + "is" + (endTime -startTime));
			
		}
	}

}
