package searching_and_sorting;

public class bubble_sort {
	public static void bubbleSort(int [] input) {
		for(int i=0;i<input.length-1;i++) {
			for(int j=0;j<input.length-i-1;j++) {
				int current=j;
				int next=j+1;
				if(input[current]>input[next]) {
					int temp=input[current];
					input[current]=input[next];
					input[next]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {6,9,4,8,3,1};
		bubbleSort(input);
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}

	}

}
