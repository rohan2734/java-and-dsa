package oops_concepts;

public class FractionUse {
	
	public static void temp(){
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
		int i=10;
		try {
			f1.setDenominator(0);
			i++;//in case of no exception
		}catch(ZeroDenominatorException e) {
			//incase of exception
			System.out.print("hey dont input 0 as denominator");
		}finally {
			//always execute it even though the there is a exception or not
		}
		/**
		 * here when f1.setDenominator(0), 
		 * then it immediately goes in the catch block, and it doesnt increase i 
		 * meaning that it doesnt execute that line 
		 * but the i++ is executed when the f1.setDenominator(10) is not 0
		 */
		f1.print();
		
		Fraction f2=new Fraction(3,4);
		f1.add(f2);
		f1.print();
		f2.print();
		
		Fraction f3=new Fraction(4,5);
//		f3.multiply(f1,f2);
//		f3.print();
//		f3=>3/5
//		f2.print();
		//f2=>3/4
	}
	public static void main(String[] args) throws ZeroDenominatorException{
		temp();
//		String s="";
//		File f;
//		try {
//			f = new File(s);
//			//read file
//		}catch(FileNotFoundException exception) {
//
//		}finally {
//			f.close();
//		}
		/**
		 * when there is common code in try and catch, 
		 * then instead of replicating the code
		 * we will write it in finally
		 */
	}
}
