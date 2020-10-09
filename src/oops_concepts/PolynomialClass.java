package oops_concepts;

public class PolynomialClass {
	private int data[];
	//private int nextIndex;
	private int max=0;
	
	public PolynomialClass() {
		data= new int[100000];
		//nextIndex=0;
	}
	
	public void setCoefficient(int deg,int coeff) {
		if(max<deg) {
			max=deg;
		}
		data[deg]=coeff;
	}
	
//	public void addElement() {
//		int temp[]=data;
//		data = new int[data.length*2];
//		for(int i=0;i<temp.length;i++) {
//			data[i]=temp[i];
//		}
//	}
	
	public int getCoefficient(int deg) {
		if(deg>=max) {
			//TODO error out
			return -1;
		}
		return data[deg];
	}
	
	public int degree() {
		return max;
	}
	
	public void print() {
		for(int deg=0;deg<=this.max;deg++) {
			if(data[deg]!=0) {
				System.out.print(data[deg]+"x^"+deg+"+ ");
			}
		}
	}
	
	public PolynomialClass add(PolynomialClass p) {
		int maxLength=Math.max(p.max, this.max);
		//int maxArrayLength=Math.max(p.data.length, this.data.length);
		
		for(int deg=0;deg<=maxLength;deg++) {
			this.data[deg]=p.data[deg]+this.data[deg];
		}
		return this;
	}
	
	public PolynomialClass subtract(PolynomialClass p) {
		int maxLength=Math.max(p.max, this.max);
		//int maxArrayLength=Math.max(p.data.length, this.data.length);
		
		for(int deg=0;deg<=maxLength;deg++) {
			this.data[deg]=-p.data[deg]+this.data[deg];
		}
		return this;
	}
	
	public PolynomialClass multiply(PolynomialClass p) {
		int temp[] =this.data;
		int maxLength=this.max;
		for(int deg1=0;deg1<=this.max;deg1++) {
			for(int deg2=0;deg2<=p.max;deg2++) {
				if(this.data[deg1]!=0 && this.data[deg2]!=0) {
					temp[deg1+deg2]+=this.data[deg1]*p.data[deg2];
					if(maxLength<deg1*deg2) {
						maxLength=deg1*deg2;
					}
				}
			}
		}
		this.max=maxLength;
		this.data=temp;
		return this;
	}
	
	public int evaluate(int x) {
		int answer=0;
		for(int deg=0;deg<this.max;deg++) {
			answer+=data[deg]*(Math.pow(x, deg));
		}
		return answer;
	}
	
//	public static PolynomialClass add(PolynomialClass p1,PolynomialClass p2) {
//		PolynomialClass p3=new PolynomialClass();
//		int minLength=Math.min(p1.data.length,p2.data.length);
//		int maxLength=Math.max(p1.data.length,p2.data.length);
//		
//		for(int deg=0;deg<minLength;deg++) {
//			p3.data[deg]=p1.data[deg]+p2.data[deg];
//		}
//		while(p3.data.length>maxLength) {
//			p3.addElement();
//		}
//		for(int deg=minLength;deg<p1.data.length;deg++) {
//			p3.data[deg]=p1.data[deg];
//		}
//		for(int deg=minLength;deg<p2.data.length;deg++) {
//			p3.data[deg]=p2.data[deg];
//		}
//		return p3;
//	}
	
}
