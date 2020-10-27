package recursion_2;

public class binary_search_recursion {
	
	public static int binary_search(int input[],int li,int ri,int element) {
		int mid=(li+ri)/2;
		if(input.length == 0) {
			return -1;
		}
		
		if(input[mid] == element) {
			return mid;
		}else if(li<=ri && input[mid] > element) {
			return binary_search(input,li,mid-1,element);
		}else if(li<=ri && input[mid] < element) {
			return binary_search(input,mid+1,ri,element);
		}else {
			return -1;
		}
		
	}
	
	public static int binary_search(int input[],int element) {
		return binary_search(input,0,input.length-1,element);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {2,3,4,5,6,8};
		int element = 5;
		int output = binary_search(input,element);
		System.out.print(output);
	}

}
