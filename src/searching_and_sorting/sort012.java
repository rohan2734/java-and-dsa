package searching_and_sorting;

public class sort012 {
	public static void sort01 (int[] arr) {
		int i=0,nz=0,nt=arr.length-1;
		while(i<nt) {
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
				if(arr[i] == 0) {
					 swap=arr[nz];
					arr[nz]=arr[i];
					arr[i]=swap;
					i++;
					nz++;
				}else {
					i++;
				}
			}
		}
		
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0,1,2,0,2,0,1};
		sort01(arr);

	}

}
