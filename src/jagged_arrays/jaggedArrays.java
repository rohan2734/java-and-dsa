package jagged_arrays;

public class jaggedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int[3][5];
		System.out.println(arr[0]);
		
		int arr2[][]=new int[4][];
		//here we specified number of rows, but we didnt mention number of columns
		//now since we dont know the size of the 1d array, there would not be any 1d arrays created
		//System.out.println(arr2[0]); //prints null
		//so in every entry of master array, it has null
		
		
//		for(int i=0;i<arr2.length;i++) {
//			arr2[i]= new int[2];
//			System.out.println(arr2[i]);
//		}
		
		for(int i=0;i<arr2.length;i++) {
			arr2[i]= new int[i+2];
		}
		
		
		//we can aslo create a 2darray with different sizes of 1d array , these are called as jagger arrays
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
