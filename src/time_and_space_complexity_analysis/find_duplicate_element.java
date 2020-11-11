package time_and_space_complexity_analysis;

public class find_duplicate_element {

	public static int lecturers_findDuplicate(int input[]) {
		int sum=0;
		
		for(int i=0;i< input.length;i++) {
			sum+=input[i];
		}
		int len = input.length-2;
		int sumOfN = ((len)*(len+1))/2;
		return sum-sumOfN;
	}
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
	
	public static int findDuplicate ( int input[]) {
		int output=0;
		
		mergeSort(input);
		int i=0;
		while(i<input.length) {
			if(i+1 < input.length && input[i]!=input[i+1]) {
				i++;
				
			}else {
				output=input[i];
				i++;
				break;
			}
		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {0,7,2,5,4,7,1,3,6};
		
		//int output = findDuplicate(input);
		int output=lecturers_findDuplicate(input);
		System.out.println("output:" + output);
	}

}
