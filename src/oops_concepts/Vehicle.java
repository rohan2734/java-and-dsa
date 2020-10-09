package oops_concepts;

public class Vehicle {

	String color;
	private int maxSpeed;
	
	/**
	 * here the maxSpeed is private, only Vehicle class can access it,
	 * even the children of the Vehicle class cannot access the maxSpeed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed=maxSpeed;
	}
	public void print() {
		System.out.println("Vehicle Color : " + color);
		System.out.println("Vehicle maximum speed : " + maxSpeed);
	}
}
