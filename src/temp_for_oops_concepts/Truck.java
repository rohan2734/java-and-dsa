package temp_for_oops_concepts;

import oops_concepts.Vehicle;

public class Truck extends Vehicle{
	int maxLoadingCapacity;
	public void print() {
		System.out.println("truck capacity:" + maxLoadingCapacity);
		/*
		 * here the String color is not public 
		 * it is only package friendly
		 */
		System.out.println("truck color: " + color);
		System.out.println("truck speed: " + getMaxSpeed());
	}
}
