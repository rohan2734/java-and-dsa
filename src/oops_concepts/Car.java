package oops_concepts;

public class Car extends Vehicle{	
	int numGears;
	boolean isConvertible;
	
	public Car(int numGears,int maxSpeed) {
		super(maxSpeed);
		this.numGears=numGears;
		System.out.println("Car Constructor");
	}
	
	public void print() {
		super.print();
		/**
		 * this calls the print function of the parent class
		 * that is the print function of the vehicle class
		 * 
		 */
		
//		System.out.println("car Color : " + color);
//		System.out.println("car maximum speed : " + getMaxSpeed());
//		System.out.println("Car numGears : " +numGears );
//		System.out.println("Car isConvertible : " + isConvertible);
		System.out.println("car's print");
	}
	/**
	 * here when the print function is there in the vehilce and Car
	 * then when you call the print from car,it will check where there is a print in car,
	 *  if yes it will use the print in the car class, 
	 *  if no , it will use the print in the vehicle class 
	 */
}
