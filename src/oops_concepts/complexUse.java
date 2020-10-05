package oops_concepts;

public class complexUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNumber c1=new ComplexNumber();
		c1.setReal(5);
		c1.setImaginary(6);
		//5+i6
		//c1.print();
		ComplexNumber c2=new ComplexNumber();
		c2.setReal(4);
		c2.setImaginary(3);
		//4+i3
		c2.add(c1);
		//c2.print();
		//9+i9
		
		ComplexNumber c3=new ComplexNumber();
		c3.setReal(4);
		c3.setImaginary(5);
		//4+i5
		c3.multiply(c1);
		c3.print();
		
		c3.conjugate();
		c3.print();
		
		
	}

}
