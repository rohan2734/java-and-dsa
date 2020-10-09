package oops_concepts;

public class VehicleUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle v1=new Vehicle();
		v1.color="black";
		v1.print();
		
		Car c=new Car();
		c.numGears=10;
		c.color="black";
		c.print();
		System.out.println(c.getMaxSpeed());
		c.print();
	}

}
