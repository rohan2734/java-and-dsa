package oops_concepts;

public class Vehicle {

	protected String color;
	private int maxSpeed;
	
	public  Vehicle(int maxSpeed) {
		this.maxSpeed=maxSpeed;
		System.out.println("Vehicles constructor");
	}
	
	/**
	 * here the maxSpeed is private, only Vehicle class can access it,
	 * even the children of the Vehicle class cannot access the maxSpeed
	 */
	
	/**
	 * protected
	 * is friendly to the package and
	 * it can be accessed outside the package  only to the children class
	 * @return
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed=maxSpeed;
	}
	public void print() {
		//System.out.println("Vehicle's print");
		System.out.println("Vehicle Color : " + color);
		System.out.println("Vehicle maximum speed : " + maxSpeed);
	}
}
