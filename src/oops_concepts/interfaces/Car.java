package oops_concepts.interfaces;

//we cannot extend from more than one class
public class Car extends Vehicle implements VehicleInterface,CarInterface{
	@Override
	public void print(){
		
	}
	
	@override
	public int getMaxSpeed() {
		return 0;
	}
	
	@Override
	public String getcompany() {
		return null;
	}
}
