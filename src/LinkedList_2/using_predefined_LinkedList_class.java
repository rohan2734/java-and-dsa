package LinkedList_2;
import java.util.LinkedList;//this class is doubly linked list
public class using_predefined_LinkedList_class {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        list.add(10);
        list.add(30);//adds at last, addLast method is same as add method
        list.addFirst(40);
        list.addFirst(70);
        list.set(2, 100); //index,value
        
        System.out.println(list.size());
        
        for(int i=0;i<list.size();i++){
        	System.out.print(list.get(i)+" ");
        }
        
	}

}
