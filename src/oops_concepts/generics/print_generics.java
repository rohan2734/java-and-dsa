package oops_concepts.generics;

public class print_generics {
//	public static void printArray(int a[]) {
//		for(int i=0;i<a.length;i++) {
//			System.out.print(a[i]);
//			System.out.print(" ");
//		}
//		System.out.println();
//	}
	
//	public static<T> void printArray(T a[]) {
//		for(int i=0;i<a.length;i++) {
//			System.out.print(a[i]);
//			System.out.print(" ");
//		}
//		System.out.println();
//	}
	
	
	
	public static<T extends PrintInterface> void printArray(T a[]) {
		for(int i=0;i<a.length;i++) {
			a[i].print();
			System.out.print(" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[] = new Integer[10];
		for(int i=0;i<10;i++) {
			a[i] = i+1;
		}
		//int a[] = new int[10];
		String s[] = new String[10];
		for(int i=0;i<10;i++) {
			s[i] = "abc";
		}
		//printArray(s); //printArray is not applicable for argument int, but is applicable for Integer
		
		
		Vehicle v[] = new Vehicle[10];
		for(int i=0;i<10;i++) {
			v[i] = new Vehicle(10);
		}
		printArray(v);
		
		Student s1[] = new Student[10];
		for(int i=0;i<10;i++) {
			s1[i] = new Student();
		}
		printArray(s1);
		
		
	}

}
