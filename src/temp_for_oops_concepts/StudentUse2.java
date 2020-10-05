package temp_for_oops_concepts;

import oops_concepts.Student;

public class StudentUse2 {
	public static void main(String args[]) {
		Student s1 =new Student();
		s1.name="rohan";
		System.out.println(s1.getRollNumber());
		//s.rollNumber=100; //since we declared as default. if we declare it as public , then it is accessible 
	}
	
}
