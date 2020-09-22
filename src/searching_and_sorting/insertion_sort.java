package searching_and_sorting;

public class insertion_sort {
	
	public static void insertionSort(int [] input) {
		for(int i=0;i<input.length-1;i++) {
			int next = i+1;
			int current=i;
			
			for( current=i;current>=0;current--) {
				if(input[current] > input[next]) {
					int temp = input[next];
					input[current+1]=input[current];
					next-=1;
					input[next]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int input[]= {9,8,5,6,2,1};
		insertionSort(input);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i] + " ");
		}
		
	}

}
