package recursion_2;

public class quick_sort {
	
	public static int partition(int input[],int si,int ei) {
		int pivotElement=input[si];
		int count=0;
		int pi=si;
		for(int i=si+1;i<=ei;i++) {
			
			if(pivotElement >= input[i]) {
				count+=1;
			}
		}
		
		pi= si + count;
		int swap = input[si];
		input[si] = input[pi];
		input[pi]= swap;
		
		int i=si,j=ei;
		while(i<pi && j> pi) {
			while(input[i] <= input[pi] && i<pi) {
				i++;
			}
			while(input[j] > input[pi] && j>pi) {
				j--;
			}
			if(input[i] > input[pi] && input[j] <=input[pi]) {
				swap = input[i];
				input[i] = input[j];
				input[j] = swap;
				i++;
				j--;
			}
		}		
		return pi;
		
		
	}
	
	public static void quickSort(int input[],int si,int ei) {
		if(si>=ei) {
			return;
		}
		int pi = partition(input,si,ei);
		quickSort(input,si,pi-1);
		quickSort(input,pi+1,ei);
	}
	public static void quickSort(int input[]) {
		quickSort(input,0,input.length-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {6,2,20,8,15,3,4};
		quickSort(input);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i] +" ");
		}
	}

}
