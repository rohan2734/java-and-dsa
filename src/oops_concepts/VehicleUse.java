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
		/**
		 * when there is no parent class created and we create  a  children class
		 * and we also call the print function of the parent class in the children class
		 * and try to run, it works fine becuase,
		 * here the compiler is creating a vehicle object for us and calling the constructor
		 * 
		 * but the problem comes when we change the constructor to accept a argument, 
		 * then the default constructor is removed and the it cannot find the constructor and it returns error
		 * 
		 * or we can also  have a default constructor in the parent class
		 * 
		 * or we can set the same parameter in the children class using super(maxSpeed) in the Car class
		 *  which is the child class
		 */
		//c.print();
		/**
		 * when the Car class is a children class of vehicle class
		 * and the using the super, you call the print function of the parent class in the children class
		 * as the super.print,
		 * then the c.print() would be printing the print function of the parent class
		 * 
		 */
		//System.out.println(c.getMaxSpeed());
		//c.print();
	
		
		Vehicle v= new Car(15,25);
		
		/**
		 * here Vehicle v is creating a reference, 
		 * and that reference can point towards car,truck,bike
		 * since every car,truck and bike is a vehicle
		 */
		
		//boolean ans = v.isConvertible();
		
		/**
		 * here even though the vehicle object is pointing towards a car in the line "Vehicle v= new Car(15,25)"
		 * this works fine becuase the car is the subclass of the vehcile
		 * but isConvertible belongs to a car class and every vehicle cannot have it
		 * for example ,truck doesnt have it.
		 */
		
		v.print();
		
		/**
		 * here since every vehicle is going to have print, it is fine .
		 * (it also checks for print function in vehicle class, 
		 * at compile time , it checks whether the function is there or not,
		 * and at run time it decides which funciton to be called)
		 * so only functions and variables speecific to vehicle can be called
		 * but not subclasses of it, since  v is pointing from vehicle
		 */
		
		/**
		 * here the print funciton calls the car's print function, 
		 * but it cant call isConvertible,
		 * here at runtime we decide which function to be called.
		 */
		
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
		
		/**
		 * here the compiler doesnt know whether the user will create a Car object or vehicle object
		 * it just checks if the isconvertible function is there in vehicle class or not
		 */
	}

}
