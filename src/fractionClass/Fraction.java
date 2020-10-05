package fractionClass;

public class Fraction {
	private int numerator,denominator;
	
	public Fraction(int numerator,int denominator) {
		this.numerator=numerator;
		if(denominator==0) {
			//TODO error out
		}
		this.denominator=denominator;
		simplify();
	}
	
	public void print() {
		if(numerator==1) {
			System.out.print(numerator);
		}else {
			System.out.print(this.numerator+"/"+this.denominator);
		}
		
	}
	public void setNumerator(int numerator) {
		this.numerator=numerator;
		simplify();
	}
	public void setDenominator(int denominator) {
		if(denominator==0) {
			//TODO error out
			return;
		}
		this.denominator=denominator;
		simplify();
	}
	public int getDenominator() {
		return this.denominator;
	}
	
	public void add(Fraction f2) {
		this.numerator=this.numerator*f2.denominator+this.denominator*f2.numerator;
		this.denominator=this.denominator*f2.denominator;
		simplify();
	}
	//here the funciton is static because f1 shouldnt change,
	public static Fraction add(Fraction f1,Fraction f2) {
		int newNum=f1.numerator*f2.denominator+f2.numerator*f1.denominator;
		int newDen=f1.denominator*f2.denominator;
		Fraction f=new Fraction(newNum,newDen);
		return f;
	}
	
	public void multipy(Fraction f1,Fraction f2) {
		this.denominator=this.denominator*f2.denominator;
		this.numerator=this.numerator*f2.numerator;
		simplify();
	}
	private void simplify() {
		int gcd=1;
		int smaller=Math.min(numerator, denominator);
		for(int i=2;i>=smaller;i++) {
			if(numerator % i==0 && denominator %i==0) {
				gcd=i;
			}
		}
		numerator/=gcd;
		denominator=denominator/gcd;
	};
	
}
