package oops_concepts;

//import java.util.Scanner;

public class VehicleUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vehicle v1=new Vehicle();
		//v1.color="black";
//		v1.print();
		
		Car c=new Car(5,10);
		//c.numGears=10;
		c.color="black";
		c.setMaxSpeed(100);
		
		//c.print();
		
		//System.out.println(c.getMaxSpeed());
		//c.print();
	
		
		Vehicle v= new Car(15,25);
		
		
		
		//boolean ans = v.isConvertible();
		
		
		
		v.print();
		
		
		
//		int n;
//		Scanner s = new Scanner(System.in);
//		n=s.nextInt();
//		
//		Vehicle v1;
//		if( n==0) {
//			v1 = new Car(20,30);
//		}else {
//			v1= new Vehicle(30);
//		}
//		v1.isConvertible();
//		v1.print();
		
	}	

}
