package recursion;

public class tower_of_Hanoi {
	
	public static void  towerOfHanoi(int n,char from_rod,char to_rod,char aux_rod) {
		if(n==1) {
			System.out.println(from_rod + " " + to_rod);
			return;
		}
		towerOfHanoi(n-1,from_rod,aux_rod,to_rod);
		System.out.println(from_rod + " " + to_rod);
		towerOfHanoi(n-1,aux_rod,to_rod,from_rod);
		
	}
	
	public static void towerOfHanoi2(int disks, char source, char auxiliary, char destination) {
		// Write your code here
        if(disks == 0){
            return;
        }
        if(disks == 1){
            System.out.println(source +" " +  destination);
            return;
        }
        
           towerOfHanoi2(disks-1,source,destination,auxiliary);
            System.out.println(source +" " + destination);
            towerOfHanoi2(disks-1,auxiliary,source,destination);
        

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=2;
		towerOfHanoi(n,'a','c','b');
	}

}
