package oops_concepts;

public class Student {
	public String name;
	//private int rollNumber;
	/*
	 * for declaring variables which cannot be changed , we use keyword called "final"
	 */
	private final int rollNumber;
	
	/*
	 * here we are setting the rollNumber by default as 100.
	 */
	
	/*
	 * even a final variable value can be changed only with constructor 
	 * now here if u use constructor that initializes only name , then final rollNumber must also be initialized
	 * else if you are using a  cosntructor that initializes name and final rollNumber that is fine.
	 */
//	public Student() {
//		rollNumber=100;
//	}
	
	/*
	 * here we declare that, we can create a student
	 * with name, and without roll no.
	 * or with both name and roll no.
	 */
	public Student(String name) {
		//System.out.print(this);
		this.name=name;
		this.rollNumber=100;
	}
	
	/*
	 * here it is compulsary to give both name and rollNumber
	 */
	public Student(String name,int rollNumber){
		this.name=name;
		this.rollNumber=rollNumber;
	}
	/*
	 * here when we need to access a data member(variable of the student class),
	 * and we want to assign the value of a local variable(variable of the setter function)
	 * where both the names of the local and data variables are same, 
	 * then by getting the refernce to the student, we can get the data variables
	 */
	
	
	/*
	 * when we declare vairables using private keyword,
	 * that variables can be only used in between the two flower brackets only.
	 *like
	 *private int rollNumber;
	 *if we dont mention anything it is  defualt
	 *the types of access modifiers are
	 *1.default ,2.private ,3.public.
	 *1.default:
	 *It is only visible in the same package.
	 *ex-1. for StudentUse1 since it is in the same package.
	 *it is not visible in the different package.
	 *ex-2 for StudentUse2, it is not visible
	 *3.public
	 *we can make it visible for the other packages also
	 *using public keyword.
	 */
	
	/*
	 * by default name is intitalized to null
	 *  and rollnumber is initialized to int 
	 */
//	public void setRollNumber(int rn) {
//		if(rn<=0) {
//			return;
//		}
//		rollNumber = rn;
//	}
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void print() {
		System.out.println(name+ " : " + rollNumber);
	}
}
