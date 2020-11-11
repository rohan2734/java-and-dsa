package time_and_space_complexity_analysis;

public class pair_sum_in_an_array {
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
	public static int pair_sum(int input[],int num,int si,int count) {
		if(si>=input.length) {
			if(count == 2 && num == 0) {
				return 1;
			}else {
				return 0;
			}
		}
		
		int smallAns1 = pair_sum(input,num,si+1,count);
		int smallAns2 = pair_sum(input,num-input[si],si+1,count+1);
		
		return smallAns1+smallAns2;
	}
	public static int pair_sum(int input[],int num) {
		int startIndex=0;
		int count=0;
		mergeSort(input);
		return pair_sum(input,num,startIndex,count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int input[]= {1,3,6,2,5,4,3,2,4};
		int input[] = {3,3,9,9,9};
		int num=12;
		int output= pair_sum(input,num);
		System.out.print(output);
		
	}

}
