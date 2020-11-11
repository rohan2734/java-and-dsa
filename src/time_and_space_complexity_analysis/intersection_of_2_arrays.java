package time_and_space_complexity_analysis;

public class intersection_of_2_arrays {
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
	public static void mergeSort(int input[]) {
		mergeSort(input,0,input.length-1);
	}
	
	public static void findIntersection(int input1[],int input2[]) {
		mergeSort(input1);
		mergeSort(input2);
		
		int output[]=new int[Math.min(input1.length, input2.length)];
		
		int i=0,j=0,k=0;
		while(i<input1.length && j<input2.length) {
			if(input1[i] == input2[j]) {
				output[k]=input1[i];
				k++;
				i++;
				j++;
			}else if(input1[i] < input2[j]) {
					i++;
			}else {
				j++;
			}
			
		}
		
		for( i=0;i<output.length;i++) {
			if(output[i]!=0) {
				System.out.print(output[i] +" ");
			}
			
		}
	}
	
	/**
	 *  we can also use a method, where the minimum length array is sorted.
	 *   and we iterate over the another largest array, and we use binary search over the second array
	 *   but the problem here is , if we have duplicates in one array, 
	 *   then this process doesnt work.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input1[]= {2,6,8,5,4,3};
		int input2[]= {2,3,4,7};
		
		 findIntersection(input1,input2);
		//System.out.print(output);
		
	}

}
