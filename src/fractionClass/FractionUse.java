package fractionClass;

public class FractionUse {
	public static void main(String[] args) {
		Fraction f1=new Fraction(20,30);
		f1.print();
		// 2/3
		
		
		f1.setNumerator(12);
		//12/3 => //4/1
		int d=f1.getDenominator();
		System.out.println(d);
		f1.print();
		//4/1 => //4
		
		f1.setNumerator(10);
		f1.setDenominator(30);
		f1.print();
		
		Fraction f2=new Fraction(3,4);
		f1.add(f2);
		f1.print();
		f2.print();
		
		Fraction f3=new Fraction(4,5);
		f3.multiply(f1,f2);
		f3.print();
		//f3=>3/5
		f2.print();
		//f2=>3/4
		
	}
}
