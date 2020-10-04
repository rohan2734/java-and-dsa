package oops_concepts;

import java.util.Scanner;

public class StudentUse1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		//Student s1= new Student();
		/**
		 * now the default construtor doesnt work , since we have set a new constructor by which
		 * objects can be created only after passing two inputs
		 */
		//Student s1=new Student("Ankush",123);
		Student s1= new Student("Ankush");
		//System.out.println(s1);
		//s1.name="Ankush";
		//s1.setRollNumber(-123);
		//s1.rollNumber=123;
		//System.out.println(s1.name);
		//System.out.println(s1.getRollNumber());
		s1.print();

		Student s2= new Student("Manisha");
		//s2.name="Manisha";
		//s2.setRollNumber(-124);
		//s2.rollNumber=121;
		//System.out.print(s2.name);
		s2.print();
		//System.out.print(s1.numStudents);
		//System.out.print(s2.numStudents);
		System.out.print(s1.getNumStudents()); //this is the better way to access numStudents
		
		
		/**
		 * static datatypes are accessed by the names of the class
		 * non static datatypes are accessed by the names of the objects
		 */
		/**
		 * num students values for both of the objects is same
		 * becuase they are referring to the same value that is stored somewhere.
		 * whole class has only one numStudents
		 */
		/**
		 * within the package we dont need to write a import statement in another file 
		 * to create a instance of the class in another file.
		 * well if it was the opposite, we should have used the import statement.
		 */
		
		/**
		 * constructor:
		 * is a function which lets u create new objects
		 */
	}

}
