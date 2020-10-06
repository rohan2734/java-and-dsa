package oops_concepts;

public class PolynomialClass {
	private int data[];
	private int nextIndex;
	
	public PolynomialClass() {
		data= new int[5];
		nextIndex=0;
	}
	
	public void setCoefficient(int deg,int coeff) {
		if(deg<nextIndex) {
			data[deg]=coeff;
		}else if(deg == nextIndex) {
			addElement();
			data[deg]=coeff;
		}else {
			return;
		}
	}
	
	public void addElement() {
		int temp[]=data;
		data = new int[data.length*2];
		for(int i=0;i<temp.length;i++) {
			data[i]=temp[i];
		}
	}
	
	public int getCoefficient(int deg) {
		if(deg==nextIndex) {
			//TODO error out
			return -1;
		}
		return data[deg];
	}
	
	public int degree() {
		return data.length-1;
	}
	
	public void print() {
		for(int deg=0;deg<data.length;deg++) {
			System.out.print(data[deg]+"x^"+deg+"+ ");
		}
	}
	
	public void add(PolynomialClass p) {
		int minArrayLength=Math.min(p.data.length, this.data.length);
		for(int deg=0;deg<p.data.length;deg++) {
			this.data[deg]+=p.data[deg];
		}
	}
	
	public void subtract(PolynomialClass p) {
		int minArrayLength=Math.min(p.data.length, this.data.length);
		for(int deg=0;deg<p.data.length;deg++) {
			this.data[deg]-=p.data[deg];
		}
	}
	
	public void multiply(PolynomialClass p) {
		
		for(int deg1=deg1<this.data.length;deg1++) {
			for(int deg2=deg2<p.data.length;deg2++) {
				this.data[deg1+deg2]=this.data[deg1]*p.data[deg2];
			}
		}
	}
	
	public int evaluate(int x) {
		
	}
	
	public static PolynomialClass add(PolynomialClass p1,PolynomialClass p2) {
		
	}
	
}
