package time_and_space_complexity_analysis;

public class Time_for_selection_sort {
	public static void selectionSort(int[] input) {
		for (int i=0;i<input.length-1;i++) {
			
			int min=input[i];
			int minIndex=i;
			for(int j=i+1;j<input.length;j++) {
				if(input[j]<min) {
					min=input[j];
					minIndex=j;
				}
			}
			if(minIndex != i) {
				int temp=input[i];
				input[i]=min;
				input[minIndex]=temp;
			}
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int n=10; n<= 10000000; n=n*10) {
			int[] input = new int[n];
			for(int i=0;i<input.length;i++) {
				input[i] = input.length-i;
			}
			
			long startTime = System.currentTimeMillis();
			selectionSort(input);
			long endTime = System.currentTimeMillis();
			System.out.println("Time by mergeSort for " + n + " is " + (endTime -startTime));
			
		}
	}

}
