package oops_concepts;

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
	}

}
