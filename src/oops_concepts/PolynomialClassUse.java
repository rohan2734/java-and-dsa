package oops_concepts;

public class PolynomialClassUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PolynomialClass p1=new PolynomialClass();
		
		p1.setCoefficient(0,3);
		//x^0 coeff 3
		p1.setCoefficient(2,2);
		//3x^0+x^2
		//p1.print();
		
		PolynomialClass p2=new PolynomialClass();
		p2.setCoefficient(0,3);
		p2.setCoefficient(2,2);
		p2.setCoefficient(1,4);
		p2.setCoefficient(2,5);
		p2.setCoefficient(6, 4);
		//3x^0+4x^1+5X^2+4x^6
		//p2.print();
		
//		PolynomialClass p4=new PolynomialClass();
//		p4=p1.add(p2);
//		p4.print();
		//p1.print();
		//p2.print();
		
		p2.multiply(p1);
		p2.print();
		
//		
//		PolynomialClass p3= PolynomialClass.add(p1,p2);
//		p3.print();
//		p1.print();
//		p2.print();
		
		
		
	}

}
