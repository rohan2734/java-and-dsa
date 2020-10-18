package recursion;

public class indices_of_Number {
	
		public static int[] indicesOfNumber(int input[],int x,int startIndex,int storage[],int index) {
			 
	        if(startIndex>=input.length) {
				return storage;
			}
			if(input[startIndex] == x) {
				storage[index]=startIndex;
				index+=1;
			}
			indicesOfNumber(input,x,startIndex+1,storage,index);
			return storage;
		}
		
		public static int[] indicesOfNumber(int input[],int x) {
			int index=0;
			 int storage[] = new int[input.length];
			storage= indicesOfNumber(input,x,0,storage,index);
			int len=0;
			for(int i=0;i<storage.length;i++) {
				if(storage[i] == 0) {
					len=i;
					break;
				}
			}
			int temp[] = new int[len];
			for(int i=0;i<len;i++) {
				temp[i]=storage[i];
			}
			return temp;
			
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int input[]= {9,8,10,8,8};
			int x=8;
			int storage[]=indicesOfNumber(input,x);
			for(int i=0;i<storage.length;i++) {
				System.out.print(storage[i]+" ");
		}
	}

}
