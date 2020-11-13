package oops_concepts;

public class Car extends Vehicle{	
	int numGears;
	boolean isConvertible;
	
	public Car(int numGears,int maxSpeed) {
		super(maxSpeed);
		this.numGears=numGears;
		System.out.println("Car Constructor");
	}
	
	public boolean isConvertible() {
		return isConvertible;
	}
	
	
	
	public void print() {
		super.print();
		
//		System.out.println("car Color : " + color);
//		System.out.println("car maximum speed : " + getMaxSpeed());
		System.out.println("Car numGears : " +numGears );
//		System.out.println("Car isConvertible : " + isConvertible);
		System.out.println("car's print");
	}
}
