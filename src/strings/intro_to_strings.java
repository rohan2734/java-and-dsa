package strings;

public class intro_to_strings {
	
	public static void print(String s) {
		for (int i=0;i<s.length();i++) {
			System.out.print(s.charAt(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c='c';
		String str ="abcdefgh";
		str="abc";
		str = str+"def";
		System.out.println(str);
		//here it prints str as "abcdef" , because here the reference is changing
		//but the content in the string str is not chaning by some method called
		//setCharAt(i);
		/** 
		 * because , when String str1="abc" |a|b|c|
		 * and String str2="abc" will also point towards same |a|b|c| for optimization
		 * so if we were to change at one place, it could have changed at every place
		 * so it  was not recommended.
		 * */
		//string is a non primitive data type and we use reference
		System.out.println(str.concat("ghi"));//concat function
		System.out.println(str);
		
		System.out.println(str.charAt(1));
		//System.out.print(str[1]); //it is not the right way
		System.out.println(str.length());
		System.out.println(str.length()); //for length
		System.out.println(str.substring(1,6)); //for substring //end index char is not included, from start to end-1 is printed 
		System.out.println(str.substring(3)); //prints from start to end of array
		System.out.println(str);//prints complete string
		
		String temp=str.substring(str.length());
		System.out.println(temp.length());
		
		System.out.println(str.contains("cde"));
		
		print(str);
		
		/**
		 * where as int[] arr1={1,2,3};
		 * int[] arr2={1,2,3};
		 * addresses are different so
		 * if(arr1 ==arr2){
		 * 	System.out.print("equal");
		 * }else{
		 * System.out.print("unqeual");
		 * }
		 * prints unequal
 		 * */
		String str1="abc";
		String str2="abc";
		//for comparing content use str1.equals(str2)
		//if you want to compare reference use str1 == str2
		if(str1.equals(str2)) {
			System.out.println("equal");
		}else {
			System.out.println("unqeual");
		}
		//strings are immutable
		
	}

}
