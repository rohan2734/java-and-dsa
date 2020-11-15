package oops_concepts.generics;

public class PairUse_generics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Pair p = new Pair(1,2);
//		p.setFirst(10);
//		System.out.println(p.getFirst());
//		System.out.println(p.getSecond());
//		
//		PairString ps = new Pair("ab","cd");
		
		Pair<String,String> p = new Pair<String,String>("ab","cd");
		p.setFirst("def");
		String s = p.getFirst();
		
		Pair<Integer,Integer> p1= new Pair<Integer,Integer>(1,2);
		
		//if we want to pass two different type of parameters
		
		Pair<String,Integer> p2 = new Pair<String,Integer>("ab",2);
		
		Pair<Integer,Integer> internalPair = new Pair<>(1,2);
		Pair<Pair<Integer,Integer>,Integer> p3 = new Pair<>(internalPair,3);
		//we can also make three integers , with first type as Pair<Integer,Integer> and second one as <Integer>
		
		System.out.println(p3.getSecond());
		System.out.println(p3.getFirst().getFirst());
		System.out.println(p3.getFirst().getSecond());
	}

}
