package oops_concepts;

public class Vehicle {

	protected String color;
	private int maxSpeed;
	
	public  Vehicle(int maxSpeed) {
		this.maxSpeed=maxSpeed;
		System.out.println("Vehicles constructor");
	}
	
	
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
