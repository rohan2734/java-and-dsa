package oops_concepts;

public class ComplexNumber {
	private int real;
	private int imaginary;
	
	public int getReal() {
		return this.real;
	}
	public int getImaginary() {
		return this.imaginary;
	}
	public void setReal(int real) {
		this.real=real;
	}
	public void setImaginary(int imaginary) {
		this.imaginary=imaginary;
	}
	public void print() {
		System.out.println(this.real+" + i"+this.imaginary);
	}
	public void add(ComplexNumber c2) {
		this.real=this.real+c2.real;
		this.imaginary=this.imaginary+c2.imaginary;
	}
	public static ComplexNumber add(ComplexNumber c1,ComplexNumber c2) {
		ComplexNumber c3=new ComplexNumber();
		c3.real=c1.real+c2.real;
		c3.imaginary=c1.imaginary+c2.imaginary;
		return c3;
	}
	public  void multiply(ComplexNumber c2) {
		int real=this.real;
		this.real=this.real*c2.real - this.imaginary*c2.imaginary;
		this.imaginary=real*c2.imaginary+c2.real*this.imaginary;
	}
	public void conjugate() {
		this.imaginary=-1*this.imaginary;
	}
	

}
