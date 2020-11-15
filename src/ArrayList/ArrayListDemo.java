package ArrayList;

import java.util.ArrayList;
public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list1 = new ArrayList<>(5);
//		System.out.println(list1.size());
		list1.add(15);
		list1.add(20); // 0  1  2 
		list1.add(25); // 15 20 25
		list1.add(2,50);//15 20 50 25
		
		//list1.get(5);//index out of bound exception
		//System.out.println(list1.size());
		//System.out.println(list1.get(2)); //at which index 
	    
		for(int i=0;i<list1.size();i++) {
			System.out.print(list1.get(i) +" ");
		}
		System.out.println();
		//for each loop
		for(int elem:list1) {
			System.out.print(elem +" ");
		}
//		list1.remove(1);
//		list1.set(1, 100);
//		for(int i=0;i<list1.size();i++) {
//			System.out.print(list1.get(i) +" ");
//		}
	}

}
