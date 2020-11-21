package LinkedList;

import java.util.Scanner;

public class eliminate_duplicates {

	/**
	 * @param args
	 */
	public static Node<Integer> takeInput(){
		Node<Integer> head = null,tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		
		while(data != -1){
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null){
				head = newNode;
				tail = newNode;
			}else{
				Node<Integer> temp = head;
				tail.next = newNode;
				tail = newNode;
			}
			data=s.nextInt();
		}
		return head;
	}
	public static void printNodes(Node<Integer> head){
		Node<Integer> temp = head;
		
		while(head != null) {
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
		head=temp;
	}
	
	public static Node<Integer> eliminateDuplicates(Node<Integer> head){
		Node<Integer> temp1 = head;
		Node<Integer> temp2 = head;
        if( temp1==null || temp1.next == null ){
            return head;
        }
        temp2=temp2.next;
		
		while(temp1!=null ){
			
            
			while(temp2 != null && temp1.data.equals(temp2.data)){//temp1.data == temp2.data is invalid
				/* == is a reference comparison, i.e. both objects point to the same memory location
				.equals() evaluates to the comparison of values in the objects 
				*/
				temp2=temp2.next;
			}
			temp1.next =temp2;
            temp1=temp2;
            if(temp2!=null){
            	 temp2=temp2.next;
            }
           
		}
       
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		
		head = eliminateDuplicates(head);
		printNodes(head);
		
		
		
	}

}
