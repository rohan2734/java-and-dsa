package searching_and_sorting;

public class lecturers_sort012 {
	public static void sort012(int[] arr) {
		 int i=0,nz=0,nt=arr.length-1;
			while(i<=nt) {
				if(arr[i] == 1) {
					i++;
				}else if(arr[i] ==0) {
					int swap=arr[nz];
					arr[nz]=arr[i];
					arr[i]=swap;
					nz++;
	                i++;
				
				}else if(arr[i] == 2){
					int swap=arr[nt];
					arr[nt]=arr[i];
					arr[i]=swap;
					nt--;
					
				}
			}
			
			for(i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,0,2,1,0,1,2,0};
		sort012(arr);

	}

}
