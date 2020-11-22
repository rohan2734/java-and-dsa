package LinkedList_2;

import java.util.Scanner;

public class find_midpoint {

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
	 public static Node<Integer> midPoint(Node<Integer> head) {
	        //Your code goes here
		 Node<Integer> slow=head;
		 Node<Integer> fast=head;
	        if(head == null || head.next == null){
	            return head;
	        } 
	        while(fast.next != null && fast != null){
	            fast=fast.next.next;
	            if(fast==null){
	                return slow;
	            }
	            slow=slow.next;
	            
	        }
	        return slow;
	        

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
		
		head = midPoint(head);
		System.out.print(head.data);
		
		
	}

}
